package utils.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.selenium.Settings;

import java.util.Locale;

import static utils.selenium.Driver.browser;

public class WebElementsHelpers {
    private int sec = Settings.WaitTime;

    public WebDriverWait weWaitForSeconds() {
        WebDriverWait wait = new WebDriverWait(browser(), sec);
        return wait;
    }

    public boolean weElementIsDisplayed(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public boolean weElementToBeClickable(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }


    public void weClick(WebElement element) {
        weElementToBeClickable(element);
        element.click();
    }

    public void weSendKeys(WebElement element, String text, boolean clearFirst) {
        weElementIsDisplayed(element);
        if (clearFirst) {
            weClick(element);
            element.clear();
        }
        element.sendKeys(text);
    }

    public boolean weElementIsInvisible(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.invisibilityOf(element));
        return !element.isDisplayed();
    }

    public String weGetAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public boolean waitUntilValueChanges(WebElement element) {
        weWaitForSeconds().until(ExpectedConditions.attributeContains(element,"aria-live","assertive"));
        return element.isDisplayed();
    }



}
