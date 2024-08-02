package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import static StepDefinitions.BaseSteps.driver;

public class Home {

    By headerMenu = By.xpath("//ul[@class='top-menu notmobile']/li");
    By categoryHeading = By.xpath("//div[@class='page-title']//h1");
    ArrayList<String> expectedCategory,actualCategory;

    public void homepageDisplayVerification(){
       Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
    }

    public void CategoryNavigation() throws InterruptedException {
        int categoriesCount = driver.findElements(headerMenu).size();
        for (int i = 1; i <= categoriesCount; i++) {
            Thread.sleep(1000);
            WebElement Category = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[" + i + "]/a"));
            Categories currentCategory = Categories.valueOf(Category.getText().replaceAll(" ", ""));
            expectedCategory.add(currentCategory.getCategories()) ;
            Category.click();
            WebElement titleText = driver.findElement(categoryHeading);
            actualCategory.add(titleText.getText());
        }
    }

    public void  navigatedCategoryVerification(){
        Assert.assertEquals(expectedCategory, actualCategory);
    }
}



