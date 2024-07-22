package Pages.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.List;

public class Home {

    WebDriver driver;
    By headerMenu = By.xpath("//ul[@class='top-menu notmobile']/li");
    By categoryHeading = By.xpath("//div[@class='page-title']//h1");
    By selectCurrency = By.xpath("//*[@id='customerCurrency']/option[2]");
    By featuredProducts = By.xpath("(//div[@class='item-grid'])[2]//span");
    By getProductTitle = By.xpath("//div[@class=\"details\"]//a");
    By getProductPrice = By.xpath("//div[@class=\"details\"]//span");
    By sortByOptions = By.xpath("//select[@id=\"products-orderby\"]");
    By getproductDetail;

    ArrayList<String> data = new ArrayList<>();
    ArrayList<Double> intData = new ArrayList<>();

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void CategoryNavigation() throws InterruptedException {

        int categoriesCount = driver.findElements(headerMenu).size();
        for (int i = 1; i <= categoriesCount; i++) {
            Thread.sleep(1000);
            WebElement Category = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[" + i + "]/a"));
            Categories currentCategory = Categories.valueOf(Category.getText().replaceAll(" ", ""));
            String expectedCategory = currentCategory.getCategories();
            Category.click();
            WebElement titleText = driver.findElement(categoryHeading);
            String actualCategory = titleText.getText();

            Assert.assertEquals(expectedCategory, actualCategory);
        }
    }

    public void SubCategoryNavigation() throws InterruptedException {

        Actions action = new Actions(driver);
        for (int i = 1; i <= 3; i++) {
            int subcategoryCount = driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[" + i + "]/ul/li/a")).size();
            for (int j = 1; j <= subcategoryCount; j++) {
                Thread.sleep(1000);
                WebElement categoryHover = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[" + i + "]"));
                action.moveToElement(categoryHover).perform();
                WebElement SubCategory = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[" + i + "]/ul/li[" + j + "]/a"));
                SubCategories currentSubCategory = SubCategories.valueOf(SubCategory.getText().replaceAll(" ", "").replaceAll("&",""));
                String expectedSubCategory = currentSubCategory.getSubCategories();
                SubCategory.click();
                WebElement titleText = driver.findElement(categoryHeading);
                String actualSubCategory = titleText.getText();

                Assert.assertEquals(actualSubCategory,expectedSubCategory);
            }
        }
    }

    public void CurrencyChange() {

        driver.findElement(selectCurrency).click();
        List<WebElement> featuredProductList = driver.findElements(featuredProducts);
        for (WebElement webElement : featuredProductList) {
            char productCurrency = webElement.getText().charAt(0);
            double actualProductPrice = Double.parseDouble(webElement.getText().substring(1));
            double expectedProductPrice = actualProductPrice / 0.86;
            Assert.assertEquals('€', productCurrency);
            Assert.assertEquals(expectedProductPrice, (actualProductPrice / 0.86));
        }
    }

    public boolean SortingComparator(ArrayList<String> data, String selection){

        intData.clear();
        boolean isSorted = true;
        if(data.getFirst().charAt(0)!='$')
        {
            switch(selection){
            case "Name: A to Z" :
                for (int i = 0; i < data.size()-1; i++) {
                    if (data.get(i).compareToIgnoreCase(data.get(i + 1)) > 0) {
                        isSorted = false;
                        break;
                    }
                } break;
            case "Name: Z to A":
                for (int i = 0; i < data.size()-1; i++) {
                    if (data.get(i).compareToIgnoreCase(data.get(i + 1)) < 0) {
                        isSorted = false;
                        break;
                    }
                } break;

             }
        }
        else {
            for (int i = 0; i < data.size(); i++) {
                String a = data.get(i);
                String b = a.substring(a.indexOf('$') + 1).replace(",", "");
                double c = Double.parseDouble(b);
                intData.add(c);
            }
            switch (selection) {
                case "Price: Low to High":
                    for (int i = 0; i < data.size() - 1; i++) {
                        if (intData.get(i) > intData.get(i + 1)) {
                            isSorted = false;
                            break;
                        }
                    }break;
                case "Price: High to Low":
                    for (int i = 0; i < data.size() - 1; i++) {
                        if (intData.get(i) < intData.get(i + 1)) {
                            isSorted = false;
                            break;
                        }
                    }break;
            }
        }
        if (isSorted) return true;
        else return false;
    }

    public void SortByFunctionality(String selection) throws InterruptedException {

        if (selection.contains("Name")) {
            getproductDetail = getProductTitle;
        }
        if (selection.contains("Price")){
            getproductDetail = getProductPrice;
        }

        Actions action = new Actions(driver);
            for (int i = 1; i <= 3; i++) {
                int subcategoryCount = driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[" + i + "]/ul/li/a")).size();
                for (int j = 1; j <= subcategoryCount; j++) {
                    WebElement categoryHover = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[" + i + "]"));
                    action.moveToElement(categoryHover).perform();

                    WebElement SubCategory = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[" + i + "]/ul/li[" + j + "]/a"));
                    SubCategory.click();

                    Select select = new Select(driver.findElement(sortByOptions));
                    select.selectByVisibleText(selection);

                    Thread.sleep(3000);

                    List<WebElement> productTitleList = driver.findElements(getproductDetail);
                    for (WebElement element : productTitleList) {
                        String title = element.getText();
                        data.add(title);
                    }
                    SoftAssert softAssert = new SoftAssert();
                    softAssert.assertTrue(SortingComparator(data, selection));
                    data.clear();
                }
            }
        }
    }



