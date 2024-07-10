package Test;

import Pages.nopCommerce.Home;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_008_Home_VerifyCurrencyChangeFunctionality extends Base {
    Home obj_CurrencyChange;

    @Test
    public void VerifyCurrencyChangeFunctionality() throws InterruptedException {
        obj_CurrencyChange = new Home(driver);
        obj_CurrencyChange.CurrencyChange();
    }
}
