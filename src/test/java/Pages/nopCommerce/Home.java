package Pages.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Home {

    WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void CategoryNavigation() throws InterruptedException {

        int categoriesCount = driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li")).size();

        for (int i = 1; i <= categoriesCount; i++) {
            Thread.sleep(3000);
            WebElement Category = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+ i +"]/a"));

            Categories currentCategory = Categories.valueOf(Category.getText().replaceAll(" ",""));
            String expectedCategory = currentCategory.getCategories();
            Category.click();

            WebElement titleText = driver.findElement(By.xpath("//div[@class=\"page-title\"]//h1"));
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

                WebElement titleText = driver.findElement(By.xpath("//div[@class=\"page-title\"]//h1"));
                String actualSubCategory = titleText.getText();

                Assert.assertEquals(expectedSubCategory, actualSubCategory);

            }
        }

    }
}
