package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import static StepDefinitions.BaseSteps.driver;

public class ProductDetail {

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
    Actions action = new Actions(driver);

    public void navigateToProductDetailPage(){
        action.moveToElement(driver.findElement(particularProduct)).click().perform();
    }

    public void moveToWriteReviewSection(){
        action.moveToElement(driver.findElement(writeReviewSection)).perform();
    }

    public void writeReview(String title, String text, String Rating){

        driver.findElement(reviewTitle).sendKeys(title);
        driver.findElement(reviewText).sendKeys(text);
        driver.findElement(By.xpath("//div[@class='rating-options']/input[@value="+Rating +"]")).click();
    }

    public void submitReviewBtn(){
        driver.findElement(submitReviewButton).click();
    }

    public void reviewAddedSuccessfully(){
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
