package Pages.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ProductDetail {

    WebDriver driver;
    By particularProduct = By.xpath("//div[@data-productid=\"1\"]");
    By writeReviewSection = By.xpath("//div[@class=\"form-fields\"]");
    By reviewTitle = By.xpath("//input[@class=\"review-title\"]");
    By reviewText = By.xpath("//textarea[@class=\"review-text\"]");
    By rating = By.xpath("//input[@value=\"5\"]");
    By submitReviewButton = By.xpath("//button[@name=\"add-review\"]");
    By reviewAddedValidation = By.xpath("//*[@id=\"bar-notification\"]/div/p");

    public ProductDetail(WebDriver driver){
        this.driver= driver;
    }

    public void writeReview(String[] data){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(particularProduct)).click().perform();
        action.moveToElement(driver.findElement(writeReviewSection)).perform();
        driver.findElement(reviewTitle).sendKeys(data[0]);
        driver.findElement(reviewText).sendKeys(data[1]);
        driver.findElement(By.xpath("//div[@class='rating-options']/input[@value="+data[2]+"]")).click();
        driver.findElement(submitReviewButton).click();

        String validationText=driver.findElement(reviewAddedValidation).getText();
        Assert.assertEquals("Product review is successfully added.",validationText);
    }
}
