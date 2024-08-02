package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import Pages.Register;
import java.util.List;

public class RegisterSteps {

    Register obj_Register = new Register();

    @Given("User navigates to Register Page")
    public void user_navigates_to_register_page() {
        obj_Register.navigateToRegisterPage();
    }

    @When("User enters below details")
    public void user_enters_below_details(DataTable dataTable) throws InterruptedException {
        List<List<String>> registerList = dataTable.asLists(String.class);
        for (List<String> registerData : registerList) {
            obj_Register.fillRegisterDetails(registerData);
        }
    }

    @And("Clicks on Register Button")
    public void clicks_on_register_button() throws InterruptedException {
        obj_Register.registerBtnClick();
    }

    @Then("Verify that Registration is successful")
    public void verify_that_registration_is_successful() {
        obj_Register.registrationSuccessfulVerification();
    }
}
