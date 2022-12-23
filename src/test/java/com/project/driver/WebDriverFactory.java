package com.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverFactory {

    protected WebDriverFactory(){};

    static WebDriver driver;
    private static final String WINDOWS_DRIVER = "/src/test/resources/drivers/chromedriver.exe";
    private static final String MAC_DRIVER = "/src/test/resources/drivers/chromedriver-mac";
    private static final String LINUX_DRIVER = "/usr/bin/chromedriver";
    private static final String DIR_PATH = System.getProperty("user.dir");

    /**
     *
     * @param browserName
     * @return
     */
    public static WebDriver getDriver(String browserName) {
        if (browserName.equals("chrome")) {
            WebDriverManager.getInstance(CHROME).setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox"); //Bypass OS security model
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            //chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--start-maximized");
          //  System.setProperty("webdriver.chrome.driver",getDriver());
            driver = new ChromeDriver(chromeOptions);
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

}


