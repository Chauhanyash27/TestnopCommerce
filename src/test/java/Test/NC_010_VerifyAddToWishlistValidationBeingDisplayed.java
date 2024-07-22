package Test;

import Pages.nopCommerce.ProductDetail;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_010_VerifyAddToWishlistValidationBeingDisplayed extends Base {

    ProductDetail obj_AddToWishlistValidation;

    @Test
    public void VerifyAddToWishlistValidationBeingDisplayed(){
        obj_AddToWishlistValidation = new ProductDetail(driver);
        obj_AddToWishlistValidation.checkAddToWishlistValidation();
    }

}
