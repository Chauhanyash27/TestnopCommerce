package Pages;

import org.openqa.selenium.By;
import static StepDefinitions.BaseSteps.driver;

public class Login {

    By loginNavItem = By.xpath("//a[@class='ico-login']");
    By emailField = By.xpath("//input[@class='email']");
    By passwordField = By.xpath("//input[@class='password']");
    By loginButton = By.xpath("//button[@class='button-1 login-button']");
    By logoutButton = By.xpath("//a[@class='ico-logout']");

    public void navigateToLoginPage(){
        driver.findElement(loginNavItem).click();
    }

    public void fillLoginDetails(String email,String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void loginBtnClick(){
        driver.findElement(loginButton).click();
    }

    public void logout(){
        driver.findElement(logoutButton).click();
    }
}
