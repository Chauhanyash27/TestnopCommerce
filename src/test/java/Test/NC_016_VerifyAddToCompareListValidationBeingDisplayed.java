package Test;

import Pages.nopCommerce.CompareProducts;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_016_VerifyAddToCompareListValidationBeingDisplayed extends Base {

    CompareProducts obj_AddToComparelistValidation;

    @Test
    public void VerifyAddToCompareListValidationBeingDisplayed(){
        obj_AddToComparelistValidation = new CompareProducts(driver);
        obj_AddToComparelistValidation.checkAddToCompareListValidation();
    }
}