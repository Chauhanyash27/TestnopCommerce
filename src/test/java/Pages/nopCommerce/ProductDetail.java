package Pages.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetail {
    WebDriver driver;

    public ProductDetail(WebDriver driver){
        this.driver= driver;
    }

    @Test
    public void writeReview(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[@data-productid=\"1\"]"))).click().perform();
        action.moveToElement(driver.findElement(By.xpath("//div[@class=\"form-fields\"]"))).perform();
        driver.findElement(By.xpath("//input[@class=\"review-title\"]")).sendKeys("Testing review");
        driver.findElement(By.xpath("//textarea[@class=\"review-text\"]")).sendKeys("Testing Comment field");
        driver.findElement(By.xpath("//input[@value=\"5\"]")).click();
        driver.findElement(By.xpath("//button[@name=\"add-review\"]")).click();

        String validationText=driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p")).getText();

        Assert.assertEquals("Product review has been added",validationText);

    }
}
