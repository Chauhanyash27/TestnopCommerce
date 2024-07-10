package Pages.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Home {

    WebDriver driver;
    By headerMenu =By.xpath("//ul[@class='top-menu notmobile']/li");
    By categoryHeading = By.xpath("//div[@class='page-title']//h1");
    By currencySelect = By.xpath("//*[@id='customerCurrency']/option[2]");
    By featuredProducts = By.xpath("//div[@class=\"product-grid home-page-product-grid\"]//div[@class=\"item-grid\"]//div[@class='item-box']");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void CategoryNavigation() throws InterruptedException {

        int categoriesCount = driver.findElements(headerMenu).size();

        for (int i = 1; i <= categoriesCount; i++) {
            Thread.sleep(3000);
            WebElement Category = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+ i +"]/a"));

            Categories currentCategory = Categories.valueOf(Category.getText().replaceAll(" ",""));
            String expectedCategory = currentCategory.getCategories();
            Category.click();

            WebElement titleText = driver.findElement(categoryHeading);
            String actualCategory = titleText.getText();

            Assert.assertEquals(expectedCategory,actualCategory);
        }
    }

    public void SubCategoryNavigation() throws InterruptedException {

        Actions action= new Actions(driver);

        for(int i=1;i<=3;i++){
            int subcategoryCount = driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+i+"]/ul/li/a")).size();
            for(int j=1;j<=subcategoryCount;j++){
                Thread.sleep(3000);
                WebElement categoryHover = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+i+"]"));
                action.moveToElement(categoryHover).perform();

                WebElement SubCategory = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+i+"]/ul/li["+j+"]/a"));
                SubCategories currentSubCategory = SubCategories.valueOf(SubCategory.getText().replaceAll(" ",""));
                String expectedSubCategory = currentSubCategory.getSubCategories();
                SubCategory.click();

                WebElement titleText = driver.findElement(categoryHeading);
                String actualSubCategory = titleText.getText();

                Assert.assertEquals(expectedSubCategory, actualSubCategory);

            }
        }
    }

    public void CurrencyChange(){
        driver.findElement(currencySelect).click();
        int featuredProductsCount = driver.findElements(featuredProducts).size();
        for(int i=1;i<=featuredProductsCount;i++){
            WebElement featuredProduct=driver.findElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]//div[2]//div["+i+"]//div//div[2]//div[3]//div[1]//span"));
            char productCurrency =featuredProduct.getText().charAt(0);
            Assert.assertEquals('€', productCurrency);;
        }
    }
}
