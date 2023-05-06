package pageObjects;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.java.Log;

import static utils.Endpoints.CREATE_ACCOUNT_URI;
import static utils.Endpoints.LOGIN_PAGE;

@Log
public class LoginPage {

    private final String emailSelector = "#email";
    private final String passwordSelector = "#pass";
    private final String loginButton = "#send2";

    Page page;
    BrowserContext context;

    public LoginPage(Page page, BrowserContext context) {
        this.page = page;
        this.context = context;
    }

    public void navigateTo() {
        page.navigate(LOGIN_PAGE);
    }

    protected void fill(String selector, String text) {
        page.fill(selector, text);
    }

    public void click() {
        page.click(loginButton);
    }

    public void enterEmail(String email) {
        fill(emailSelector, email);
    }

    public void enterPassword(String password) {
        fill(passwordSelector, password);
    }


}