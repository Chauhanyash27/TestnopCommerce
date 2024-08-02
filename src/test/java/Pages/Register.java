package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import static StepDefinitions.BaseSteps.driver;

public class Register {

    By registerNavItem = By.xpath("//a[@class='ico-register']");
    By gender = By.xpath("//*[@id='gender-male']");
    By firstName = By.xpath("//*[@id='FirstName']");
    By lastName = By.xpath("//*[@id='LastName']");
    By dateOfBirthDay = By.xpath("//select[@name='DateOfBirthDay']");
    By dateOfBirthMonth = By.xpath("//select[@name='DateOfBirthMonth']");
    By dateOfBirthYear = By.xpath("//select[@name='DateOfBirthYear']");
    By email = By.xpath("//*[@id='Email']");
    By companyName = By.xpath("//*[@id='Company']");
    By password = By.xpath("//*[@id='Password']");
    By confirmPassword = By.xpath("//*[@id='ConfirmPassword']");
    By registerButton = By.xpath("//button[@id='register-button']");
    By logoutNavItem = By.xpath("//a[@class='ico-logout']");
    By registerSuccess = By.xpath("//div[@class='result']");

    public void navigateToRegisterPage(){
        driver.findElement(registerNavItem).click();
    }

    public void fillRegisterDetails(List<String> data) throws InterruptedException {

        driver.findElement(gender).click();
        driver.findElement(firstName).sendKeys(data.get(1));
        driver.findElement(lastName).sendKeys(data.get(2));

        Select Day = new Select(driver.findElement(dateOfBirthDay));
        Day.selectByVisibleText(data.get(3));

        Select Month = new Select(driver.findElement(dateOfBirthMonth));
        Month.selectByVisibleText(data.get(4));

        Select Year = new Select(driver.findElement(dateOfBirthYear));
        Year.selectByVisibleText(data.get(5));

        driver.findElement(email).sendKeys(data.get(6));
        driver.findElement(companyName).sendKeys(data.get(7));
        driver.findElement(password).sendKeys(data.get(8));
        driver.findElement(confirmPassword).sendKeys(data.get(9));
        Thread.sleep(1000);

    }

    public void registerBtnClick() throws InterruptedException {
        driver.findElement(registerButton).click();
        Thread.sleep(1000);
    }

    public void registrationSuccessfulVerification(){
        String actualRegisterConfirmed = driver.findElement(registerSuccess).getText();
        Assert.assertEquals(actualRegisterConfirmed,"Your registration completed");
        driver.findElement(logoutNavItem).click();
    }
}
