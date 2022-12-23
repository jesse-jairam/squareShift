package com.project.Suite;

import com.project.driver.WebDriverManager;
import com.project.utils.Settings;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class InitializationSuiteListener implements ISuiteListener {

    private static String BROWSER_PROPERTIES = "browser.properties";
    private static String CONFIG_PROPERTIES = "config.properties";

    @Override
    public void onStart(ISuite suite) {
        initializePropertyFiles(suite);
        WebDriverManager.initialize();
    }

    @Override
    public void onFinish(ISuite suite) {
        WebDriverManager.tearDown();
    }

    private void initializePropertyFiles(ISuite suite) {
        initializeConfigProperties(suite);
        initializeBrowserProperties(suite);
    }

    private void initializeBrowserProperties(ISuite suite) {
        Settings.initializeBrowser(suite.getParameter(BROWSER_PROPERTIES));
    }

    private void initializeConfigProperties(ISuite suite) {
        Settings.initializeConfig(suite.getParameter(CONFIG_PROPERTIES));
    }
}
