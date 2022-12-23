package com.project.test;

import com.project.driver.WebDriverManager;
import com.project.utils.Settings;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;

public class TestBase {

    protected static Logger log = Logger.getLogger(TestBase.class.getName());

    public void navigateToPage() {
        log.info("Navigating to Site :" + Settings.getTestUrl());
        WebDriverManager.getDriver().navigate().to(Settings.getTestUrl());
       // WebDriverManager.getDriver().manage().window().maximize();
    }

    public void navigateToCNAInternational() {
        System.out.println(Settings.getTestUrl()+"news/international");
        log.info("Navigating to CNA International Site :" + Settings.getTestUrl()+"news/international");
        WebDriverManager.getDriver().navigate().to(Settings.getTestUrl()+"news/international");
        WebDriverManager.getDriver().manage().window().maximize();
    }

    /**
     * Softassert check for string values.
     * @param softAssert The SoftAssert instance that will collect any failures.
     * @param actual   The value we got.
     * @param expected     The value we are hoping for.
     * @param message    A note about what we are testing.
     */
    public static void assertEquals(SoftAssert softAssert, String actual, String expected, String message) {
        softAssert.assertEquals(actual, expected, ">>" + message + ": ");
    }

    /**
     * Softassert check for boolean values.
     * @param softAssert The SoftAssert instance that will collect any failures.
     * @param actual   The value we got.
     * @param expected     The value we are hoping for
     * @param message    A note about what we are testing.
     */
    public static void assertEquals(SoftAssert softAssert, boolean actual, boolean expected, String message) {
        softAssert.assertEquals(actual, expected,">>" + message + ": ");
    }

    /**
     * Softassert check for integer values.
     * @param softAssert The SoftAssert instance that will collect any failures.
     * @param actual   The value we got.
     * @param expected     The value we are hoping for.
     * @param message    A note about what we are testing.
     */
    public static void assertEquals(SoftAssert softAssert, Integer actual, Integer expected, String message) {
        softAssert.assertEquals(actual, expected,">>" + message + ": ");
    }

    protected static void holdOn(Integer millis) {
        log.debug("Sitting for " + millis + " milliseconds.");
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
