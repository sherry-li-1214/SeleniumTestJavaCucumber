package utils.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * this class is to dowload chrome web driver exe file
 * then setup and load chrome webdriver
 */
public class ChromeWebDriver {

    private static WebDriver driver;

    public static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver loadChromeDriver(String chromeArgument) {
        setupChromeDriver();

        ChromeDriverService driverService = ChromeDriverService.createDefaultService();

        ChromeOptions options = new ChromeOptions();
        options.addArguments(chromeArgument);

        driver = new ChromeDriver(driverService, options);
        return driver;
    }
}