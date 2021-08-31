package com.squareshift.test;

import com.squareshift.driver.WebDriverManager;
import com.squareshift.pages.*;
import org.testng.ITest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Scenario03Test extends TestBase implements ITest {

    private String testName = "Scenario 3 Test";
        InternationalPage internationalPage;
        WeatherPage weatherPage;


    @BeforeClass
    public void doInitializations() {
        internationalPage = new InternationalPage(WebDriverManager.getDriver());
        weatherPage = new WeatherPage(WebDriverManager.getDriver());
        navigateToCNAInternational();
    }

    @Override
    public String getTestName() {
        return testName;
    }

    @Test(priority = 1,description = "Verify that user is able to get the weather details of Singapore")
    public void Automation_Scenario_03() {
        SoftAssert softAssert = new SoftAssert();
        internationalPage.clickOnAllSections();
        internationalPage.clickOnWeather();
        String current_place = weatherPage.getCurrentPlace();
        String max_temp = weatherPage.getMaxTemp();
        String min_temp = weatherPage.getMinTemp();
        String weather_condition = weatherPage.getWeatherCondition();
        log.info("Current Place" + current_place);
        log.info("Max Temp" + max_temp);
        log.info("Min Temp" + min_temp);
        log.info("Weather Condition" + weather_condition);
        softAssert.assertAll();
    }

}

