package pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MyAccountPage extends BasePage {

    Page page;
    public MyAccountPage(Page page) {
        this.page = page;
    }

    public String confirmationMessageVisible() {
        Locator confirmationMessage = page.getByText("Thank you for registering with Main Website Store.");
        return confirmationMessage.textContent();
    }

    public String emailVisible() {
        Locator email = page.locator("#maincontent > div.columns > div.column.main > div.block.block-dashboard-info > div.block-content > div.box.box-information > div.box-content > p");
        return email.textContent();
    }

    public String errorMessageVisible(String errorMessage) {
        Locator errorText = page.getByText(errorMessage);
        return errorText.textContent();
    }
}
