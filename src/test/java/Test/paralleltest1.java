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

public class paralleltest1 extends Base{

    Home obj_CategoryNavigation;

//   @Test
//    public static void browserInitiator(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
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
    public void verifyCategoryNavigation() throws InterruptedException {

        obj_CategoryNavigation = new Home(driver);
        obj_CategoryNavigation.CategoryNavigation();
    }
}
