package Pages.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;
    By loginNavItem = By.xpath("//a[@class='ico-login']");
    By emailField = By.xpath("//input[@class='email']");
    By passwordField = By.xpath("//input[@class='password']");
    By loginButton = By.xpath("//button[@class='button-1 login-button']");
    By logoutButton = By.xpath("//a[@class='ico-logout']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }


    public void userLogin(String[] data) throws InterruptedException {

        driver.findElement(loginNavItem).click();

        driver.findElement(emailField).sendKeys(data[0]);

        driver.findElement(passwordField).sendKeys(data[1]);

        driver.findElement(loginButton).click();

        Thread.sleep(2000);

        driver.findElement(logoutButton).click();
    }

}
