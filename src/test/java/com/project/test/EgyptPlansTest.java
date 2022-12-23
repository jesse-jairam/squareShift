package com.project.test;

import com.project.driver.WebDriverManager;
import com.project.pages.EgyptPage;
import com.project.pages.STCHomePage;
import org.testng.ITest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EgyptPlansTest extends TestBase implements ITest {

    private String testName = "Egypt Plans Test";
    STCHomePage stcHomePage;
    EgyptPage egyptPage;


    @BeforeClass
    public void doInitializations() {
        stcHomePage = new STCHomePage(WebDriverManager.getDriver());
        egyptPage = new EgyptPage(WebDriverManager.getDriver());
        navigateToPage();
    }

    @Override
    public String getTestName() {
        return testName;
    }

    private HashMap expectedPrice() {
        HashMap<String, String> map = new HashMap<>();
        map.put("PREMIUM","5.1 USD/Month");
        map.put("LITE","1.3 USD/Month");
        map.put("CLASSIC", "3.2 USD/Month");
        return map;
    }

    private HashMap expectedDiscountedPrice() {
        HashMap<String, String> map = new HashMap<>();
        map.put("PREMIUM","1 USD/Month");
        map.put("LITE","0.25 USD/Month");
        map.put("CLASSIC", "0.50 USD/Month");
        return map;
    }

    @Test(priority = 1, description = "Verify that there are three plans in Egypt")
    public void Automation_Scenario_03() {
        SoftAssert softAssert = new SoftAssert();
        stcHomePage.clickOnEnglish();
        stcHomePage.clickCountrySelector();
        stcHomePage.clickEgypt();
        holdOn(3000);
        softAssert.assertEquals(egyptPage.getPlanAndPrice(egyptPage.getTypes(),egyptPage.getPrice()),expectedPrice());
        softAssert.assertEquals(egyptPage.getPlanAndPrice(egyptPage.getTypes(),egyptPage.getDiscountedPrice()),expectedDiscountedPrice());
        softAssert.assertAll();
    }

}

