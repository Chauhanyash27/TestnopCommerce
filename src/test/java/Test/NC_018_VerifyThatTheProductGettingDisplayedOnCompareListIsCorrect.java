package Test;

import Pages.nopCommerce.CompareProducts;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_018_VerifyThatTheProductGettingDisplayedOnCompareListIsCorrect extends Base {

    CompareProducts obj_ProductDetailVerification;

    @Test
    public void VerifyThatTheProductGettingDisplayedOnCompareListIsCorrect() throws InterruptedException {
        obj_ProductDetailVerification = new CompareProducts(driver);
        obj_ProductDetailVerification.productDetailVerification();
    }
}
