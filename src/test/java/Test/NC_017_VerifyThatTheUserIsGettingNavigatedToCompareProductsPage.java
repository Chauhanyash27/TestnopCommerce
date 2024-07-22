package Test;

import Pages.nopCommerce.CompareProducts;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_017_VerifyThatTheUserIsGettingNavigatedToCompareProductsPage extends Base {

    CompareProducts obj_CompareProductsPageNavigation;

    @Test
    public void VerifyThatTheUserIsGettingNavigatedToCompareProductsPage(){
        obj_CompareProductsPageNavigation = new CompareProducts(driver);
        obj_CompareProductsPageNavigation.navigateToCompareProductsPage();
    }
}
