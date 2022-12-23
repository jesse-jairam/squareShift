package com.project.test;

import com.project.driver.WebDriverManager;
import com.project.pages.AlgeriaPage;
import com.project.pages.EgyptPage;
import com.project.pages.STCHomePage;
import org.testng.ITest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class AlgeriaPlansTest extends TestBase implements ITest {

    private String testName = "Algeria Plans Test";
    STCHomePage stcHomePage;
    AlgeriaPage algeriaPage;


    @BeforeClass
    public void doInitializations() {
        stcHomePage = new STCHomePage(WebDriverManager.getDriver());
        algeriaPage = new AlgeriaPage(WebDriverManager.getDriver());
        navigateToPage();
        holdOn(3000);
    }

    @Override
    public String getTestName() {
        return testName;
    }

    private HashMap expectedPrice() {
        HashMap<String, String> map = new HashMap<>();
        map.put("PREMIUM","8 USD/month");
        map.put("LITE","2.7 USD/month");
        map.put("CLASSIC", "5.3 USD/month");
        return map;
    }
    @Test(priority = 1, description = "Verify that there are three plans in Algeria")
    public void Automation_Scenario_03() {
        SoftAssert softAssert = new SoftAssert();
        stcHomePage.clickOnEnglish();
        stcHomePage.clickCountrySelector();
        stcHomePage.clickAlgeria();
        holdOn(3000);
        softAssert.assertEquals(algeriaPage.getPlanAndPrice(algeriaPage.getTypes(),algeriaPage.getPrice()),expectedPrice());
        softAssert.assertAll();
    }

}

