package Test;

import Pages.nopCommerce.Wishlist;
import Utility.Base;
import org.testng.annotations.Test;


public class NC_011_VerifyWishlistPageDisplaysAllProductDetail extends Base {

    Wishlist obj_WishlistPageTableHeading;

    @Test
    public void VerifyWishlistPageDisplaysAllProductDetail(){
       obj_WishlistPageTableHeading = new Wishlist(driver);
       obj_WishlistPageTableHeading.navigateToWishlistPage();
       obj_WishlistPageTableHeading.wishlistItemDetails();
    }
}
