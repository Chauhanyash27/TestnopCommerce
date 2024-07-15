package Test;

import Pages.nopCommerce.Wishlist;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_012_VerifyTotalProductPriceVaryingWithProductQuantity  extends Base {

    Wishlist obj_WishlistPageTableHeading;

    @Test
    public void VerifyTotalProductPriceVaryingWithProductQuantity() {
        obj_WishlistPageTableHeading = new Wishlist(driver);
        obj_WishlistPageTableHeading.navigateToWishlistPage();
        obj_WishlistPageTableHeading.totalPriceVaryingWithQuantity();
    }
}
