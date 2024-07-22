package Test;

import Pages.nopCommerce.CompareProducts;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_019_VerifyThatTheProductIsGettingRemovedFromCompareList extends Base {

    CompareProducts obj_RemoveProductFromCompareList;

    @Test
    public void VerifyThatTheProductIsGettingRemovedFromCompareList() throws InterruptedException {
        obj_RemoveProductFromCompareList = new CompareProducts(driver);
        obj_RemoveProductFromCompareList.navigateToCompareProductsPage();
        obj_RemoveProductFromCompareList.removeProduct();
    }
}
