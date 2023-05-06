package testSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(BasePage.getPage(), BasePage.getContext());

    @Given("^I am on the login page")
    public void accessLoginPage() {
        loginPage.navigateTo();
    }
    @When("^I enter my login information:$")
    public void enterLoginInformation(DataTable registrationData) {
        List<Map<String, String>> data = registrationData.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            loginPage.enterEmail(row.get("email"));
            loginPage.enterPassword(row.get("password"));
        }
    }

    @And("^I click on the login button")
    public void performLogin() {
        loginPage.click();
    }

    @Given("I have logged in")
    public void becomeLoggedIn() {
        loginPage.navigateTo();
        loginPage.enterEmail("test2@validlogin.com");
        loginPage.enterPassword("Bucharest1234");
        loginPage.click();

    }

}
