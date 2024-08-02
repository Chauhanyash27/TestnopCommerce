package StepDefinitions;

import Pages.Login;
import io.cucumber.java.en.*;

public class LoginSteps {

    Login obj_Login = new Login();

    @Given("User navigates to Login Page")
    public void user_navigates_to_login_page() {
        obj_Login.navigateToLoginPage();
    }

    @When("User enters {string} and {string}")
    public void user_enters_email_and_password(String username, String password) {
       obj_Login.fillLoginDetails(username,password);
    }

    @And("Clicks on Login Button")
    public void clicksOnLoginButton(){
       obj_Login.loginBtnClick();
    }

    @Then("User logouts after HomePage is displayed")
    public void home_page_is_displayed() {
       obj_Login.logout();
    }
}
