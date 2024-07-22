package Test;

import Pages.nopCommerce.Wishlist;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_014_VerifyProductGettingAddedFromWishlistToCart extends Base {

    Wishlist obj_WishlistToCart;

    @Test
    public void VerifyProductGettingAddedFromWishlistToCart(){
        obj_WishlistToCart = new Wishlist(driver);
        obj_WishlistToCart.navigateToWishlistPage();
        obj_WishlistToCart.wishlistToCart();
    }
}
