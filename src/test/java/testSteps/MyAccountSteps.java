package testSteps;

import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import pageObjects.BasePage;
import pageObjects.MyAccountPage;

public class MyAccountSteps {
    SoftAssertions softAssertions = new SoftAssertions();
    MyAccountPage myAccountPage = new MyAccountPage(BasePage.getPage());

    @Then("^I land on the my account page")
    public void performSuccessfulRegistration() {
        String welcomeMessage = myAccountPage.confirmationMessageVisible();
        softAssertions.assertThat(welcomeMessage).isEqualTo("Thank you for registering with Main Website Store.");
        softAssertions.assertAll();
    }

    @Then("I am met with the error message {string}")
    public void performInvalidRegistration(String inputErrorMessage) {
        String errorMessage = myAccountPage.errorMessageVisible(inputErrorMessage);
        softAssertions.assertThat(errorMessage).isEqualTo(inputErrorMessage);
        softAssertions.assertAll();
    }

    @Then("^I see my account details")
    public void checkAccountDetails() {
        String welcomeMessage = myAccountPage.emailVisible();
        softAssertions.assertThat(welcomeMessage).contains("test@validlogin.com");
        softAssertions.assertAll();
    }
}
