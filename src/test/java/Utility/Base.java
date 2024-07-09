package Utility;

import Pages.nopCommerce.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.time.Duration;

public class Base {
    public static WebDriver driver;


    @BeforeTest
    public static void browserInitiator(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.nopcommerce.com/");
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object[][] DataProvider() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\Utility\\DataFile.xlsx";
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
}
