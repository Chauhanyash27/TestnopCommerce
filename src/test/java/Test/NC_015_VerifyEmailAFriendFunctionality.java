package Test;

import Pages.nopCommerce.ProductDetail;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_015_VerifyEmailAFriendFunctionality extends Base {

    ProductDetail obj_EmailAFriend;

    @Test
    public void VerifyEmailAFriendFunctionality(){
        obj_EmailAFriend = new ProductDetail(driver);
        obj_EmailAFriend.emailAFriend();
    }
}
