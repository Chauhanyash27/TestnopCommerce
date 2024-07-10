package Test;

import Pages.nopCommerce.ProductDetail;
import Utility.Base;
import org.testng.annotations.Test;

public class NC_005_ProductDetail_VerifyProductReviewGettingAdded extends Base {

    ProductDetail obj_SubmitReview;

    @Test(dataProvider= "ProductReviewDataProvider")
    public void VerifyProductReviewGettingAdded(String [] data) {
        obj_SubmitReview = new ProductDetail(driver);
        obj_SubmitReview.writeReview(data);
    }
}