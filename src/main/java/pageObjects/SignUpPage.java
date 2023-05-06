package pageObjects;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.java.Log;

import static utils.Endpoints.CREATE_ACCOUNT_URI;

@Log
public class SignUpPage {

    private final String firstNameSelector = "#firstname";
    private final String lastNameSelector = "#lastname";
    private final String emailSelector = "#email_address";
    private final String passwordSelector = "#password";
    private final String confirmPasswordSelector = "#password-confirmation";
    Page page;
    BrowserContext context;
    private final Locator createAccountSelector;

    public SignUpPage(Page page, BrowserContext context) {
        this.page = page;
        this.context = context;
        createAccountSelector = page.getByTitle("Create an Account");
    }

    public void navigateTo() {
        page.navigate(CREATE_ACCOUNT_URI);
    }

    protected void fill(String selector, String text) {
        page.fill(selector, text);
    }

    protected void click(String selector) {
        page.click(selector);
    }

    public void enterFirstName(String firstName) {
        fill(firstNameSelector, firstName);
    }

    public void enterLastName(String lastName) {
        fill(lastNameSelector, lastName);
    }

    public void enterEmail(String email) {
        fill(emailSelector, email);
    }

    public void enterPassword(String password) {
        fill(passwordSelector, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        fill(confirmPasswordSelector, confirmPassword);
    }

    public void clickSubmit() {
        createAccountSelector.click();
    }
}