package Test;

import Pages.nopCommerce.Home;
import Utility.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class parallelTest2 extends Base {

//    public static WebDriver driver;

    Home obj_SubCategoryNavigation;

//    @Test
//    public static void browserInitiator(){
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//        driver.get("https://demo.nopcommerce.com/");
//    }
//
//    @Test(priority = 1)
//    public void tearDown(){
//        driver.quit();
//    }
//
//    @Test
//    public void login(){
//        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
//
//        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("yash1@mailinator.com");
//
//        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("password");
//
//        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
//    }

    @Test
    public void verifySubCategoryNavigation() throws InterruptedException {
        obj_SubCategoryNavigation = new Home(driver);
        obj_SubCategoryNavigation.SubCategoryNavigation();
    }
}
