package utils.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.drivers.ChromeWebDriver;
import utils.drivers.FirefoxWebDriver;

/**
 * this class is used to contrl driver
 * based on browser type
 * default is chrome
 */
public class DriverController {

   public static DriverController instance=new DriverController() ;

    private static WebDriver webDriver;
    private String defaultBrowserType="Chrome";
    private static Logger log = LogManager.getLogger(DriverController.class.getName());
    private static ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();
    public DriverController() {
        System.out.println("browser type is:"+System.getProperty("browser"));

    }
    public static DriverController getInstance() {
        return instance;
    }
    public WebDriver getWebDriver(String browser){
        if(browser==null){
            browser=defaultBrowserType;
        }
        if (browser.equalsIgnoreCase("firefox"))
            startFirefox("--disable-extensions");
        else {
            startChrome("--disable-extensions");
            //System.out.println("Chrome driver");
        }
        //return instance.webDriver;
        return threadedDriver.get();
    }

    public void startChrome(String arg) {
        if(threadedDriver.get() != null) return;
        webDriver = ChromeWebDriver.loadChromeDriver(arg);
        threadedDriver.set(webDriver);
    }

    public void startFirefox(String arg) {
        if(threadedDriver.get() != null) return;
        webDriver = FirefoxWebDriver.loadFirefoxDriver(arg);
        threadedDriver.set(webDriver);
    }


    public void quitDriver() {
        threadedDriver.get().quit();
        threadedDriver.set(null);
    }


    public void stopWebDriver() {
        if (threadedDriver.get() == null) return;
        try
        {
          threadedDriver.get().quit();
          threadedDriver.set(null);
        }
        catch (Exception e)
        {
            log.error(e + "::WebDriver stop error");
        }

        //webDriver = null;
        log.debug(":: WebDriver stopped");
    }
}