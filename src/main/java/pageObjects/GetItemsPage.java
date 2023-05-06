package pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.java.Log;
import org.assertj.core.api.SoftAssertions;

import static utils.Endpoints.PANTS_PAGE;
@Log
public class GetItemsPage extends BasePage {
    Page page;
    SoftAssertions softAssertions = new SoftAssertions();
    final String itemLinkSelector = "#maincontent > div.columns > div.column.main > div.products.wrapper.grid.products-grid > ol > li:nth-child(1) > div > a";
    final String sizeButtonSelector = "#option-label-size-143-item-171";
    final String colorButtonSelector = "#option-label-color-93-item-50";
    final String cartButtonTitle = "Add to Cart";
    final String itemNameSelector = ".page-title";
    final String successMessageSelector = ".message-success";
    final String errorMessageSelector = "#super_attribute\\[143\\]-error";
    String pageTitle = "";
    public GetItemsPage(Page page) {
        this.page = page;
    }
    public void navigateTo() {
        page.navigate(PANTS_PAGE);
    }

    public void selectFirstItem() {
        page.locator(itemLinkSelector).click();
    }

    public void selectOptions() {
        page.locator(sizeButtonSelector).click();
        page.locator(colorButtonSelector).click();
    }

    public void addToCart() {
        page.getByTitle(cartButtonTitle).click();
    }

    public void checkAdded() {
        pageTitle = page.locator(itemNameSelector).textContent().trim();
        String successMessage = page.locator(successMessageSelector).textContent().trim();
        softAssertions.assertThat(successMessage).contains(pageTitle);
        softAssertions.assertAll();
    }

    public void errorVisible() {
        String errorMessage = page.locator(errorMessageSelector).textContent().trim();
        softAssertions.assertThat(errorMessage).isEqualTo("This is a required field.");
        softAssertions.assertAll();
    }
}
