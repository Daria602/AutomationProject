package hooks;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.assertj.core.api.SoftAssertions;
import pageObjects.BasePage;

public class Hooks {

    public BasePage basePage;
    public Page page;
    private final SoftAssertions softAssertions = new SoftAssertions();

    @Before
    public void launchBrowser() {

        basePage = new BasePage();
        page = basePage.initBrowser();
    }

    @After(order = 0)
    public void quitBrowser() {
        softAssertions.assertAll();
        page.close();
    }
}
