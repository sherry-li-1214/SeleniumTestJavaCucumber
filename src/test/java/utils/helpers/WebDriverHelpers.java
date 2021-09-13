
package utils.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.selenium.Settings;

import static utils.selenium.Driver.browser;

/**
 * this is web driver help
 * Purpose:
 * @para
 */
public class WebDriverHelpers {
    private int sec = Settings.WaitTime;
    public Object wdElementIsDisplayed(By locator) {
        //wdHighlight(locator);
        WebDriverWait wait = new WebDriverWait(browser(), sec);
        return wait.until(ExpectedConditions.visibilityOf((WebElement) locator));
    }

    public void wdElementToDisappear(By locator) {
        WebDriverWait wait = new WebDriverWait(browser(), Settings.TimeOut);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement wdFindElement(By locator) {
        wdElementIsDisplayed(locator);
        return browser().findElement(locator);
    }

    public void wdClick(By locator) {
        wdFindElement(locator).click();
    }

    public void wdSendKeys(By locator, String text, boolean clearFirst) {
        if (clearFirst) wdClick(locator);
        wdFindElement(locator).sendKeys(text);
    }


}
