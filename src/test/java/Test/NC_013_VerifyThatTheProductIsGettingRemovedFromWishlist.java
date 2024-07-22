package Test;

import Pages.nopCommerce.Wishlist;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_013_VerifyThatTheProductIsGettingRemovedFromWishlist extends Base {

    Wishlist obj_RemoveProductFromWishlist;

    @Test
    public void VerifyThatTheProductIsGettingRemovedFromWishlist() throws InterruptedException {
        obj_RemoveProductFromWishlist = new Wishlist(driver);
        obj_RemoveProductFromWishlist.navigateToWishlistPage();
        obj_RemoveProductFromWishlist.removeProduct();
    }
}
