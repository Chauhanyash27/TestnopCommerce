package Pages.nopCommerce;

import Utility.ExcelFileHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.ArrayList;

public class Login {

    WebDriver driver;
    By loginNavItem = By.xpath("//a[@class='ico-login']");
    By emailField = By.xpath("//input[@class='email']");
    By passwordField = By.xpath("//input[@class='password']");
    By loginButton = By.xpath("//button[@class='button-1 login-button']");
    By logoutButton = By.xpath("//a[@class='ico-logout']");

    public Login( WebDriver driver){
        this.driver = driver;
    }


    public static void UserLogin() throws InterruptedException, IOException {

        String filePath = System.getProperty("user.dir") + "\\Test Data\\TestData.xlsx";

        int totalRows = ExcelFileHandling.getRowCount(filePath, "LoginCredentials");

        int totalColumns = ExcelFileHandling.getColumnCount(filePath, "LoginCredentials", 0);

        ArrayList<String> data = new ArrayList<>();

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                data.add(ExcelFileHandling.getCellData(filePath, "LoginCredentials", i, j));
            }

            driver.findElement(loginNavItem).click();

            driver.findElement(By.xpath(emailField)).sendKeys(data.get(0));

            driver.findElement(By.xpath(passwordField)).sendKeys(data.get(1));

            driver.findElement(By.xpath(loginButton)).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath(logoutButton)).click();
            data.clear();
        }
        driver.close();
    }
}
