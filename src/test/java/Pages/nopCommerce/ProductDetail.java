package Pages.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ProductDetail {

    WebDriver driver;
    By particularProduct = By.xpath("//div[@data-productid=\"18\"]");
    By writeReviewSection = By.xpath("//div[@class=\"form-fields\"]");
    By reviewTitle = By.xpath("//input[@class=\"review-title\"]");
    By reviewText = By.xpath("//textarea[@class=\"review-text\"]");
    By submitReviewButton = By.xpath("//button[@name=\"add-review\"]");
    By reviewAddedValidation = By.xpath("//*[@id=\"bar-notification\"]/div/p");
    By addToWishlistIcon = By.xpath("//div[@data-productid=\"18\"]//button[@title=\"Add to wishlist\"]");
    By addToWishlistValidation = By.xpath("//p[@class=\"content\"]");
    By emailAFriendBtn = By.xpath("//button[@class=\"button-2 email-a-friend-button\"]");
    By friendsMail = By.xpath("//input[@class=\"friend-email\"]");
    By personalMessage = By.xpath("//textarea[@id=\"PersonalMessage\"]");
    By sendEmailBtn = By.xpath("//button[@class=\"button-1 send-email-a-friend-button\"]");
    By emailAFriendValidation = By.xpath("//div[@class=\"result\"]");

    public ProductDetail(WebDriver driver){
        this.driver = driver;
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

    public void checkAddToWishlistValidation(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(addToWishlistIcon)).click().perform();
        Assert.assertTrue(driver.findElement(addToWishlistValidation).isDisplayed());
        String addToWishlistValidationText = driver.findElement(addToWishlistValidation).getText();
        Assert.assertEquals(addToWishlistValidationText,"The product has been added to your wishlist");
    }

    public void emailAFriend(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(particularProduct)).click().perform();
        driver.findElement(emailAFriendBtn).click();
        driver.findElement(friendsMail).sendKeys("yash10@mailinator.com");
        driver.findElement(personalMessage).sendKeys("Hi");
        driver.findElement(sendEmailBtn).click();
        String emailAFriendValidationText=driver.findElement(emailAFriendValidation).getText();
        Assert.assertEquals(emailAFriendValidationText,"Your message has been sent.");
    }
}
