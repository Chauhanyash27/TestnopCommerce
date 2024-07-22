package Pages.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class CompareProducts {

    WebDriver driver;
    By addToCompareListIcon = By.xpath("//div[@data-productid=\"18\"]//button[@class=\"button-2 add-to-compare-list-button\"]");
    By addToComparelistValidation = By.xpath("//p[@class=\"content\"]");
    By clickOnProductComparison = By.xpath("//a[text()=\"product comparison\"]");
    By pageTitle = By.xpath("//div[@class=\"page-title\"]//h1");
    By selectedProductName = By.xpath("//div[@data-productid=\"18\"]//h2//a");
    By selectedProductPrice = By.xpath("//div[@data-productid=\"18\"]//span");
    By displayedProductName = By.xpath("//tr[@class=\"product-name\"]//a");
    By displayedProductPrice = By.xpath("//tr[@class=\"product-price\"]//td[2]");
    By removeButton = By.xpath("//button[@class=\"button-2 remove-button\"]");
    By allProductName = By.xpath("//tr[@class=\"product-name\"]//td[@style]");
    By clearListBtn = By.xpath("//a[@class=\"clear-list\"]");
    By afterClearList = By.xpath("//div[@class=\"no-data\"]");

    public CompareProducts(WebDriver driver){
        this.driver = driver;
    }

    public void checkAddToCompareListValidation(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(addToCompareListIcon)).click().perform();
        Assert.assertTrue(driver.findElement(addToComparelistValidation).isDisplayed());
        String addToCompareListValidationText = driver.findElement(addToComparelistValidation).getText();
        Assert.assertEquals(addToCompareListValidationText,"The product has been added to your product comparison");
    }

    public void navigateToCompareProductsPage(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(addToCompareListIcon)).click().perform();
        driver.findElement(clickOnProductComparison).click();
        String pageHeading = driver.findElement(pageTitle).getText();
        Assert.assertEquals(pageHeading,"Compare products");
    }

    public void productDetailVerification() throws InterruptedException {
         String expectedProductName = driver.findElement(selectedProductName).getText();
         String expectedProductPrice = driver.findElement(selectedProductPrice).getText();
         navigateToCompareProductsPage();
         String actualProductName = driver.findElement(displayedProductName).getText();
         String actualProductPrice = driver.findElement(displayedProductPrice).getText();

         Assert.assertEquals(actualProductName,expectedProductName);
         Assert.assertEquals(actualProductPrice,expectedProductPrice);
    }

    public void removeProduct() throws InterruptedException {
        String getProductName = driver.findElement(displayedProductName).getText();
        driver.findElement(removeButton).click();
        boolean status = true;
        List<WebElement> allProductNameList = driver.findElements(allProductName);
        for(WebElement particularProductName:allProductNameList){
            if (particularProductName.getText().contains(getProductName)){
                status = false;
            }
        }
        Assert.assertTrue(status,"Item not removed from Compare List Products");
    }

    public void clearList(){
        driver.findElement(clearListBtn).click();
        String afterClearingListText = driver.findElement(afterClearList).getText();
        Assert.assertEquals(afterClearingListText,"You have no items to compare.");
    }
}

