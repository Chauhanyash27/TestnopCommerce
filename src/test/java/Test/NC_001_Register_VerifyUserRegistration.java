package Test;

import Utility.Base;
import org.nopCommerce.Register;
import org.testng.annotations.*;

public class NC_001_Register_VerifyUserRegistration extends Base {

    Register obj_UserRegistration;

    @Test(dataProvider= "DataProvider")
    public void register_VerifyUserRegistration(String [] data) throws InterruptedException {
        obj_UserRegistration = new Register(driver);
        obj_UserRegistration.userRegister(data);

    }

}
