package pages;

import static utils.selenium.Driver.browser;

import utils.helpers.WebDriverHelpers;
import utils.helpers.WebElementsHelpers;
import utils.selenium.Settings;
import org.testng.Assert;

/**
 * base page provide the common method and property for the page
 */
public class BasePage extends Page {

    protected WebElementsHelpers elementHelpers = new WebElementsHelpers();
    protected WebDriverHelpers driverHelpers = new WebDriverHelpers();

    public void navigateToBaseUrl() {
        String baseUrl = Settings.baseUrl;
        browser().get(baseUrl);//navigate().to(baseUrl);
        browser().manage().window().maximize();
    }




}