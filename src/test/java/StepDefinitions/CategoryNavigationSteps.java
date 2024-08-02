package StepDefinitions;

import Pages.Home;
import io.cucumber.java.en.*;

public class CategoryNavigationSteps {

    Home obj_Home = new Home();

    @Given("User is currently on the Homepage")
    public void user_is_currently_on_the_homepage() {
       obj_Home.homepageDisplayVerification();
    }

    @When("User navigates to particular category")
    public void each_category_is_being_navigated() throws InterruptedException {
        obj_Home.CategoryNavigation();
    }

    @Then("Verify the actual and expected category")
    public void verify_the_actual_and_expected_category() {
        obj_Home.navigatedCategoryVerification();
    }
}
