package Pages.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MyAccount extends Login{
    WebDriver driver;
    By myAccountNavItem = By.xpath("//a[@class=\"ico-account\"]");
    By myAccountList = By.xpath("//div[@class=\"listbox\"]//ul//li");
    By myAccountAddresses = By.xpath("//div[@class='listbox']//ul//li[2]//a");
    By address_FirstName = By.xpath("//input[@id='Address_FirstName']");
    By address_LastName = By.xpath("//input[@id='Address_LastName']");
    By address_Email = By.xpath("//input[@id='Address_Email']");
    By address_Company = By.xpath("//input[@id='Address_Company']");
    By address_Country = By.xpath("//select[@id='Address_CountryId']");
    By address_State = By.xpath("//select[@id='Address_StateProvinceId']");
    By address_City = By.xpath("//input[@id='Address_City']");
    By address_Address = By.xpath("//input[@id='Address_Address1']");
    By address_ZipCode = By.xpath("//input[@id='Address_ZipPostalCode']");
    By address_PhoneNumber = By.xpath("//input[@id='Address_PhoneNumber']");
    By address_SaveButton = By.xpath("//button[@class='button-1 save-address-button']");
    By address_AddNewButton = By.xpath("//button[@class='button-1 add-address-button']");
    By addressAddedValidation = By.xpath("//p[@class='content']");
    By notificationClose = By.xpath("//*[@id='bar-notification']/div/span");


    public MyAccount(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void navigateToMyAccount(){
      driver.findElement(myAccountNavItem).click();
    }

    public void myAccountListNavigation() throws InterruptedException {
        int accountListCount = driver.findElements(myAccountList).size();
        for (int i = 1; i <= accountListCount; i++) {
            driver.findElement(By.xpath("//div[@class='listbox']//ul//li[" + i + "]//a")).click();
        }
    }

    public void AddAddress(String[] data) throws InterruptedException {

        driver.findElement(myAccountAddresses).click();
        driver.findElement(address_AddNewButton).click();
        driver.findElement(address_FirstName).sendKeys(data[0]);
        driver.findElement(address_LastName).sendKeys(data[1]);
        driver.findElement(address_Email).sendKeys(data[2]);
        driver.findElement(address_Company).sendKeys(data[3]);

        Select select = new Select(driver.findElement(address_Country));
        select.selectByVisibleText(data[4]);

        select = new Select(driver.findElement(address_State));
        select.selectByVisibleText(data[5]);

        driver.findElement(address_City).sendKeys(data[6]);
        driver.findElement(address_Address).sendKeys(data[7]);
        driver.findElement(address_ZipCode).sendKeys(data[8]);
        driver.findElement(address_PhoneNumber).sendKeys(data[9]);
        driver.findElement(address_SaveButton).click();

        driver.findElement(notificationClose).click();

        String actualValidationText = driver.findElement(addressAddedValidation).getText();
        String expectedValidationText= "The new address has been added successfully.";
        Assert.assertEquals(expectedValidationText,actualValidationText);
        Thread.sleep(1000);
    }

}
