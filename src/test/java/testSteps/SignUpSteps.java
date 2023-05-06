package testSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.SignUpPage;

import java.util.List;
import java.util.Map;

public class SignUpSteps {

    SignUpPage signUpPage = new SignUpPage(BasePage.getPage(), BasePage.getContext());
    private int generatedNumber = (int) Math.floor(Math.random() * (5000 - 100 + 1) + 100);
    private String email = "JohnSmith" + generatedNumber + "@test.com";

    @Given("^I am on the registration page")
    public void accessRegistrationPage() {
            signUpPage.navigateTo();
    }

    @When("^I enter my registration information:$")
    public void enterRegistrationInformation(DataTable registrationData) {
        List<Map<String, String>> data = registrationData.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            signUpPage.enterFirstName(row.get("first_name"));
            signUpPage.enterLastName(row.get("last_name"));
            signUpPage.enterEmail(email);
            signUpPage.enterPassword(row.get("password"));
            signUpPage.enterConfirmPassword(row.get("confirm_password"));
        }
    }

    @Given("^I click on the register button")
    public void performRegistration() {
        signUpPage.clickSubmit();
    }
}
