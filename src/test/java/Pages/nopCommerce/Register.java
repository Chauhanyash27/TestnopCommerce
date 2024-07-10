package Pages.nopCommerce;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {

    WebDriver driver;
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


    public Register( WebDriver driver){
        this.driver = driver;
    }

    public void userRegister(String[] data) throws InterruptedException {

        driver.findElement(registerNavItem).click();

        driver.findElement(gender).click();

        driver.findElement(firstName).sendKeys(data[1]);

        driver.findElement(lastName).sendKeys(data[2]);

        Select Day = new Select(driver.findElement(dateOfBirthDay));
        Day.selectByVisibleText(data[3]);

        Select Month = new Select(driver.findElement(dateOfBirthMonth));
        Month.selectByVisibleText(data[4]);

        Select Year = new Select(driver.findElement(dateOfBirthYear));
        Year.selectByVisibleText(data[5]);

        driver.findElement(email).sendKeys(data[6]);

        driver.findElement(companyName).sendKeys(data[7]);

        driver.findElement(password).sendKeys(data[8]);

        driver.findElement(confirmPassword).sendKeys(data[9]);

        driver.findElement(registerButton).click();

        Thread.sleep(2000);

        driver.findElement(logoutNavItem).click();
    }
}