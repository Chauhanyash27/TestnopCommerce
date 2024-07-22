package Test;

import Pages.nopCommerce.Home;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_003_Home_VerifyCategoryNavigation extends Base {

    Home obj_CategoryNavigation;

    @Test
    public void verifyCategoryNavigation() throws InterruptedException {
        obj_CategoryNavigation = new Home(driver);
        obj_CategoryNavigation.CategoryNavigation();
    }
}
