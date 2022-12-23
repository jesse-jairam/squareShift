package com.project.test;

import com.project.driver.WebDriverManager;
import com.project.pages.STCHomePage;
import org.testng.ITest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class UaePlansTest extends TestBase implements ITest {

    private String testName = "UAE plans Test";
    STCHomePage stcHomePage;


    @BeforeClass
    public void doInitializations() {
        stcHomePage = new STCHomePage(WebDriverManager.getDriver());
        navigateToPage();
    }

    @Override
    public String getTestName() {
        return testName;
    }

    private HashMap expectedItems() {
        HashMap<String, String> map = new HashMap<>();
        map.put("PREMIUM","16.3 USD/month");
        map.put("LITE","5.4 USD/month");
        map.put("CLASSIC", "10.9 USD/month");
        return map;
    }

    @Test(priority = 1, description = "Verify that there are three plans in UAE")
    public void Automation_Scenario_03() {
        SoftAssert softAssert = new SoftAssert();
        stcHomePage.clickOnEnglish();
        stcHomePage.clickCountrySelector();
        stcHomePage.clickUAE();
        holdOn(3000);
        List<String> expectedPlans = Arrays.asList("LITE", "CLASSIC", "PREMIUM");
        softAssert.assertEquals(stcHomePage.getTypes(), expectedPlans, "Verifying that three plans are available");
        softAssert.assertEquals(stcHomePage.getPlanAndPrice(), expectedItems(), "Verifying that three plans are available along with price and USD");
        softAssert.assertAll();
    }

}

