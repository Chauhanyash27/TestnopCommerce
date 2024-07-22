package Test;

import Pages.nopCommerce.Home;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_004_Home_VerifySubCategoryNavigation extends Base {

    Home obj_SubCategoryNavigation;

    @Test
    public void verifySubCategoryNavigation() throws InterruptedException {
        obj_SubCategoryNavigation = new Home(driver);
        obj_SubCategoryNavigation.SubCategoryNavigation();
    }
}
