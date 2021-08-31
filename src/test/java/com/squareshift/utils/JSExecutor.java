package com.squareshift.utils;

import com.squareshift.driver.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;

public class JSExecutor {

    /**
     * @return the instance of Javascript executor
     */
    public static JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) WebDriverManager.getDriver();
    }

}
