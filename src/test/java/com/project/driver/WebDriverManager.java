package com.project.driver;

import com.project.utils.Settings;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    private static WebDriver driver = null;
    private WebDriverManager(){};
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * The initialize method containing the setup and intended to be used in Suite Listener
     */
    public static void initialize() {
        try {
            setUp();
        } catch (Exception e) {
        }
    }

    /**
     * @return a driver instance based on the browser
     */
    private static WebDriver setUp() {
        try {
            if (null == driver) {
                driver = WebDriverFactory.getDriver(Settings.getBrowserName());
                System.out.println("Driver created ");
            }
        } catch (Exception e) {
            System.out.println("Driver Not created ");
            e.printStackTrace();
            System.exit(0);
        }
        return driver;
    }

    /**
     * This method shuts down the browser
     */
    public static void tearDown() {
        driver.quit();
    }
}
