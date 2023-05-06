package pageObjects;

import com.microsoft.playwright.*;
import lombok.extern.java.Log;

@Log
public class BasePage {

    public static BrowserContext browserContext;
    protected Browser browser;
    protected static Page page;
    protected Playwright playwright;
    private static final String DEFAULT_BROWSER = System.getProperty("browser", "chromium");
    public static ThreadLocal<Page> threadLocalDriver = new ThreadLocal<>();
    public static ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();

    public Page initBrowser() {
        playwright = Playwright.create();
        switch (DEFAULT_BROWSER) {
            case "chromium" ->
                    browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(System.getProperty("headless"))));
            case "firefox" -> browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(System.getProperty("headless"))));
            case "webkit" -> browser = Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(System.getProperty("headless"))));
        }
        browserContext = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true).setViewportSize(1920, 1080));
        log.info("Opening new page");
        page = browserContext.newPage();
        threadLocalDriver.set(page);
        threadLocalContext.set(browserContext);

        return page;
    }

    public static synchronized Page getPage() {
        return threadLocalDriver.get();
    }

    public static synchronized BrowserContext getContext() {
        return threadLocalContext.get();
    }
}
