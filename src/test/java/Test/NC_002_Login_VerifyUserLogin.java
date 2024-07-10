package Test;

import Pages.nopCommerce.Login;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_002_Login_VerifyUserLogin extends Base {

    Login obj_UserLogin;

    @Test(dataProvider= "LoginDataProvider")
    public void login_VerifyUserLogin(String [] data) throws InterruptedException {
        obj_UserLogin = new Login(driver);
        obj_UserLogin.userLogin(data);
    }
}
