package Test;

import Pages.nopCommerce.CompareProducts;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_020_VerifyThatTheCompareListIsGettingCleared extends Base {

    CompareProducts obj_ClearCompareList;

    @Test
    public void VerifyThatTheCompareListIsGettingCleared() throws InterruptedException {
        obj_ClearCompareList = new CompareProducts(driver);
        obj_ClearCompareList.navigateToCompareProductsPage();
        obj_ClearCompareList.clearList();
    }
}
