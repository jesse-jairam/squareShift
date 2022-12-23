package com.project.utils;

import com.project.driver.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;

public class JSExecutor {

    /**
     * @return the instance of Javascript executor
     */
    public static JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) WebDriverManager.getDriver();
    }

}
