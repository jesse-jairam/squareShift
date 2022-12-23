package com.project.utils;

import java.util.Properties;

public class Settings extends SettingsBase {

    protected static Properties props;
    protected static String browserFromEnv = null;
    public static String configFromEnv = null;
    private static final String KEY_BROWSERNAME = "browser.name";
    private static final String KEY_TESTURL = "test.url";
    private static final String DEFAULT_BROWSERNAME = "chrome";
    private static final String DEFAULT_TESTURL = "https://subscribe.stctv.com/";
    private static final String BROWSERSETTINGSFOLDER = "browser";
    private static final String CONFIGSETTINGSFOLDER = "config";
    private static final String BROWSER_NAME = "BROWSER_NAME";
    private static final String TEST_URL = "TEST_URL";

    /**
     * The static method to intitalize the browser property files
     * This also assigns browser values from Env variables
     *
     * @param filename
     */
    public static void initializeBrowser(String filename) {
        props = loadProperties(BROWSERSETTINGSFOLDER, filename);
        browserFromEnv = System.getProperty(BROWSER_NAME);
    }

    /**
     * The static method to intitalize the config property files
     * This also assigns Environment values from Env variables
     * @param filename
     */
    public static void initializeConfig(String filename) {
        String test = System.getenv(TEST_URL);
        configFromEnv = test;
        props = loadProperties(CONFIGSETTINGSFOLDER, filename);
    }

    /**
     * Returns the Test to use for the tests.
     * @return The specified URL whether it is Prod or test.
     */
    public static String getTestUrl() {
        if (null != configFromEnv) {
            return configFromEnv;
        } else {
            return props.getProperty(KEY_TESTURL, DEFAULT_TESTURL);
        }
    }

    /**
     * Returns the browser to use for the tests.
     * @return The specified browser.
     */
    public static String getBrowserName() {
        if (null != browserFromEnv) {
            return browserFromEnv;
        } else {
            return props.getProperty(KEY_BROWSERNAME, DEFAULT_BROWSERNAME);
        }
    }
}

