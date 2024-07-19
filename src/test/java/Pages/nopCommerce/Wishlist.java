package Pages.nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class Wishlist {
    WebDriver driver;
    By addToWishlistIcon = By.xpath("//div[@data-productid=\"18\"]//button[@title=\"Add to wishlist\"]");
    By clickOnWishlist = By.xpath("//a[text()=\"wishlist\"]");
    By wishlistTableHeadings = By.xpath("//table//th");
    By QtyField = By.xpath("//input[@class=\"qty-input\"]");
    By productPrice = By.xpath("//span[@class=\"product-unit-price\"]");
    By updateWishlistButton = By.xpath("//button[@id=\"updatecart\"]");
    By totalPrice = By.xpath("//span[@class=\"product-subtotal\"]");
    By productName = By.xpath("//tr[1]//td[@class=\"product\"]//a");
    By removeButton = By.xpath("//tr[1]//button[@class=\"remove-btn\"]");
    By allProductName = By.xpath("//td[@class=\"product\"]");
    By addToCartCheckbox = By.xpath("//input[@name=\"addtocart\"]");
    By addToCartBtn = By.xpath("//button[@name=\"addtocartbutton\"]");

    public Wishlist(WebDriver driver){
        this.driver = driver;
    }


    public void navigateToWishlistPage(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(addToWishlistIcon)).click().perform();
        driver.findElement(clickOnWishlist).click();
    }

    public void wishlistItemDetails(){
     List<WebElement> WishlistTableHeadingsList = driver.findElements(wishlistTableHeadings);
     for(WebElement heading : WishlistTableHeadingsList){
         String ActualTableHeading = heading.getText();
         WishlistTableHeadings tableHeading=WishlistTableHeadings.valueOf(ActualTableHeading.replaceAll("[(). ]", ""));
         String ExpectedTableHeading = tableHeading.getWishlistTableHeadings();
         Assert.assertEquals(ActualTableHeading,ExpectedTableHeading);
     }
    }

    public void totalPriceVaryingWithQuantity() {
        driver.findElement(QtyField).clear();
        Random random = new Random();
        int productQuantity = random.nextInt(2,10);
        driver.findElement(QtyField).sendKeys(Integer.toString(productQuantity));
        driver.findElement(updateWishlistButton).click();
        Double productSingleUnitPrice= Double.parseDouble(driver.findElement(productPrice).getText().replaceAll("[$,€]",""));
        Double expectedTotalPrice = productSingleUnitPrice*productQuantity;
        Double actualTotalPrice= Double.parseDouble(driver.findElement(totalPrice).getText().replaceAll("[$,€]",""));
        Assert.assertEquals(actualTotalPrice,expectedTotalPrice);
    }

    public void removeProduct() throws InterruptedException {
        String getProductName = driver.findElement(productName).getText();
        driver.findElement(removeButton).click();
        boolean status = true;
        List<WebElement>allProductNameList = driver.findElements(allProductName);
        for(WebElement particularProductName:allProductNameList){
            if (particularProductName.getText().contains(getProductName)){
                status = false;
            }
        }
        Assert.assertTrue(status,"Item not removed from Wishlist");
    }

    public void wishlistToCart(){
     driver.findElement(addToCartCheckbox).click();
     driver.findElement(addToCartBtn).click();
     boolean titleVerification = false;
     if(driver.getTitle().contains("Shopping Cart")) titleVerification = true;
     Assert.assertTrue(titleVerification);

    }

}
