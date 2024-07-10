package Test;

import Pages.nopCommerce.MyAccount;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_006_MyAccount_VerifyMyAccountListNavigation extends Base {
    MyAccount obj_MyAccountNavigation;

    @Test
    public void VerifyMyAccountListNavigation() throws InterruptedException {
        obj_MyAccountNavigation = new MyAccount(driver);
        obj_MyAccountNavigation.navigateToMyAccount();
        obj_MyAccountNavigation.myAccountListNavigation();
    }
}
