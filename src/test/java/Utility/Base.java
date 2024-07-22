package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class Base {
    public static WebDriver driver;
    By loginNavItem = By.xpath("//a[@class='ico-login']");
    By emailField = By.xpath("//input[@class='email']");
    By passwordField = By.xpath("//input[@class='password']");
    By loginButton = By.xpath("//button[@class='button-1 login-button']");

    @BeforeClass
    public  void browserInitiator(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @BeforeClass
    public void login(){
        driver.findElement(loginNavItem).click();
        driver.findElement(emailField).sendKeys("yash1@mailinator.com");
        driver.findElement(passwordField).sendKeys("password");
        driver.findElement(loginButton).click();
    }

    @DataProvider
    public Object[][] RegisterDataProvider() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\Test Data\\DataFile.xlsx";
        int totalRows = ExcelFileHandling.getRowCount(filePath,"RegisterTestData");
        int totalColumns = ExcelFileHandling.getColumnCount(filePath,"RegisterTestData",0);

        Object[][] data = new Object[totalRows][totalColumns];
        for(int i=1;i<=totalRows;i++){
            for(int j=0;j<totalColumns;j++){
                data[i-1][j]=(ExcelFileHandling.getCellData(filePath,"RegisterTestData",i,j));
            }
        }
        return data;
    }

    @DataProvider
    public Object[][] LoginDataProvider() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\Test Data\\DataFile.xlsx";
        int totalRows = ExcelFileHandling.getRowCount(filePath,"LoginTestData");
        int totalColumns = ExcelFileHandling.getColumnCount(filePath,"LoginTestData",0);

        Object[][] data = new Object[totalRows][totalColumns];
        for(int i=1;i<=1;i++){
            for(int j=0;j<totalColumns;j++){
                data[i-1][j]=(ExcelFileHandling.getCellData(filePath,"LoginTestData",i,j));
            }
        }
        return data;
    }

    @DataProvider
    public Object[][] ProductReviewDataProvider() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\Test Data\\DataFile.xlsx";
        int totalRows = ExcelFileHandling.getRowCount(filePath, "ProductReviewData");
        int totalColumns = ExcelFileHandling.getColumnCount(filePath, "ProductReviewData", 0);

        Object[][] data = new Object[1][totalColumns];
        for (int i = 1; i <= 1; i++) {
            for (int j = 0; j < totalColumns; j++) {
                data[i - 1][j] = (ExcelFileHandling.getCellData(filePath, "ProductReviewData", i, j));
            }
        }
        return data;
    }

    @DataProvider
    public Object[][] AddressDataProvider() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\Test Data\\DataFile.xlsx";
        int totalRows = ExcelFileHandling.getRowCount(filePath,"AddressData");
        int totalColumns = ExcelFileHandling.getColumnCount(filePath,"AddressData",0);

        Object[][] data = new Object[1][totalColumns];
        for(int i=1;i<=1;i++){
            for(int j=0;j<totalColumns;j++){
                data[i-1][j]=(ExcelFileHandling.getCellData(filePath,"AddressData",i,j));
            }
        }
        return data;
    }
}
