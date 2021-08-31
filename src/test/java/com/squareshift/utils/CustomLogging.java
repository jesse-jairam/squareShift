package com.squareshift.utils;

import com.squareshift.driver.WebDriverManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import static com.squareshift.utils.TakeScreenShot.getScreenhot;

public class CustomLogging implements ITestListener {

    Logger log = Logger.getLogger("CustomLogging");

    /**
     * This is overidden method from the ItestListener that logs event when test is started
     * and the result is intended to be used in Extent report
     *
     * @param result
     */
    public void onTestStart(ITestResult result) {
        log.info("Test --> " + result.getMethod().getMethodName() + " <-- is started");
        ExtentTestManager.startTest(result.getMethod().getMethodName(), "");
    }

    /**
     * This is overidden method from the ItestListener that logs event when test is ONLY PASSED
     * and the result is intended to be used in Extent report
     *
     * @param result
     */
    public void onTestSuccess(ITestResult result) {
        log.info("Test is success..!!");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    /**
     * This is overidden method from the ItestListener that logs event when test is ONLY FAILED
     * and the result is intended to be used in Extent report
     *
     * @param result
     */
    public void onTestFailure(ITestResult result) {
        log.info("Test is failure..!!");
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test failed :" + result.getThrowable());
        try {
            ExtentTestManager.getTest().log(LogStatus.FAIL, ExtentTestManager.getTest().addScreenCapture(getScreenhot(WebDriverManager.getDriver(), result.getName())));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This is overidden method from the ItestListener that logs event when test is Skipped
     * and the result is intended to be used in Extent report
     *
     * @param result
     */
    public void onTestSkipped(ITestResult result) {
        log.debug("Test is skipped..!!");
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.debug("Test is failed but in success percentage..!!");

    }

    public void onStart(ITestContext context) {
        log.debug("Test on start..!!");
    }

    /**
     * This is overidden method from the ItestListener that logs event when test is completed with execution
     * and the result is intended to be used in Extent report
     */
    public void onFinish(ITestContext context) {
        log.debug("Test is finish..!!");
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
}
