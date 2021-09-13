package utils.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.selenium.DriverController;

import static utils.selenium.Driver.browser;

/**
 * cucubmer hooks is to hook the action be executed
 * before or after scenarios
 */
public class CucumberHooks {

    @Before("@Chrome")
    public void beforeChrome(){
        DriverController.instance.startChrome("--disable-extensions");
    }

    @Before("@Firefox")
    public void beforeFirefox() throws Exception {
        DriverController.instance.startFirefox("--disable-extensions");
    }

    @Before("@HeadlessChrome")
    public void beforeChromeHeadless() {
        DriverController.instance.startChrome("--headless");
    }

    @Before("@HeadlessFirefox")
    public void beforeHeadlessFirefox() throws Exception {
        DriverController.getInstance().startFirefox("--headless");
    }
    @Before
    public void getWebDriver()  {
        System.out.println("get  browser before test starts");
        browser();
    }
    @After
    public void stopWebDriver() {
        DriverController.getInstance().stopWebDriver();;

    }
}