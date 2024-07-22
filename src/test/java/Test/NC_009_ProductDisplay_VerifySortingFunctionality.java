package Test;

import Pages.nopCommerce.Home;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_009_ProductDisplay_VerifySortingFunctionality extends Base {

    Home obj_Sorting;

    @Test
    public void VerifySortingFunctionality() throws InterruptedException {
        obj_Sorting = new Home(driver);
        obj_Sorting.SortByFunctionality("Price: High to Low");
    }
}
