package Test;

import Pages.nopCommerce.Wishlist;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_013_VerifyThatTheProductIsGettingRemovedFromWishlist extends Base {
    Wishlist obj_WishlistPageTableHeading;

    @Test
    public void VerifyThatTheProductIsGettingRemovedFromWishlist() throws InterruptedException {
        obj_WishlistPageTableHeading = new Wishlist(driver);
        obj_WishlistPageTableHeading.navigateToWishlistPage();
        obj_WishlistPageTableHeading.removeProduct();
    }
}
