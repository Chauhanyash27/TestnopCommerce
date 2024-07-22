package Test;

import Pages.nopCommerce.Wishlist;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_012_VerifyTotalProductPriceVaryingWithProductQuantity  extends Base {

    Wishlist obj_TotalPriceValidation;

    @Test
    public void VerifyTotalProductPriceVaryingWithProductQuantity() {
        obj_TotalPriceValidation = new Wishlist(driver);
        obj_TotalPriceValidation.navigateToWishlistPage();
        obj_TotalPriceValidation.totalPriceVaryingWithQuantity();
    }
}
