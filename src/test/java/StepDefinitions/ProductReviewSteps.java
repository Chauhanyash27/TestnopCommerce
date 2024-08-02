package StepDefinitions;

import Pages.ProductDetail;
import io.cucumber.java.en.*;

public class ProductReviewSteps {

    ProductDetail obj_ProductDetail = new ProductDetail();

    @Given("User navigates to Product Detail Page")
    public void user_navigates_to_product_detail_page() {
       obj_ProductDetail.navigateToProductDetailPage();
    }
    @And("Move to the Write Review Section")
    public void move_to_the_write_review_section() {
       obj_ProductDetail.moveToWriteReviewSection();
    }

    @When("User Fills the {string}, {string} and {string}")
    public void fill_the_review_details(String ReviewTitle, String ReviewText, String Rating){
        obj_ProductDetail.writeReview(ReviewTitle, ReviewText, Rating);
    }

    @And("Submit the Product Review")
    public void submit_the_product_review() {
        obj_ProductDetail.submitReviewBtn();
    }

    @Then("Verify that the Review is added successfully")
    public void verify_that_the_review_is_added_successfully() {
       obj_ProductDetail.reviewAddedSuccessfully();
    }

}
