package testSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import pageObjects.BasePage;
import pageObjects.GetItemsPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

import java.util.List;
import java.util.Map;

public class GetItemSteps {

    GetItemsPage getItemsPage = new GetItemsPage(BasePage.getPage());
    SoftAssertions softAssertions = new SoftAssertions();

    @And("I navigate to pants section")
    public void navigateToPants() {
        getItemsPage.navigateTo();
    }
    @And("I select first item")
    public void selectFirstItem() {
        getItemsPage.selectFirstItem();
    }
    @When("I select size and color options")
    public void selectOptions() {
        getItemsPage.selectOptions();
    }
    @And("I click Add to cart button")
    public void clickAddToCart() {
        getItemsPage.addToCart();
    }


    @Then("I see success message with selected item name")
    public void viewItem() {
        getItemsPage.checkAdded();
    }


    @Then("I see error message")
    public void errorMessageIsVisible() {
        getItemsPage.errorVisible();
    }
}
