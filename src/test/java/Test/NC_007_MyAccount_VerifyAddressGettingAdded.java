package Test;

import Pages.nopCommerce.MyAccount;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_007_MyAccount_VerifyAddressGettingAdded extends Base {

    MyAccount obj_AddAddress;

    @Test(dataProvider = "AddressDataProvider")
    public void VerifyAddressGettingAdded(String[] data) throws InterruptedException {
        obj_AddAddress = new MyAccount(driver);
        obj_AddAddress.navigateToMyAccount();
        obj_AddAddress.AddAddress(data);
    }
}
