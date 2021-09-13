package utils.selenium;

import org.openqa.selenium.WebDriver;

public class Driver {
    public static WebDriver browser() {
        DriverController instance=DriverController.getInstance() ;
        return instance.getWebDriver(System.getProperty("browser"));
    }
}