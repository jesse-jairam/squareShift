package com.squareshift.test;

import com.squareshift.driver.WebDriverManager;
import com.squareshift.pages.HomePage;
import com.squareshift.pages.InternationalPage;
import com.squareshift.pages.NewsDetailsPage;
import com.squareshift.pages.SingaporePage;
import org.testng.ITest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Scenario02Test extends TestBase implements ITest {

    private String testName = "Scenario 2 Test";
    HomePage homePage;
    NewsDetailsPage newsDetailsPage;
    InternationalPage internationalPage;
    SingaporePage singaporePage;


    @BeforeClass
    public void doInitializations() {
        homePage = new HomePage(WebDriverManager.getDriver());
        newsDetailsPage = new NewsDetailsPage(WebDriverManager.getDriver());
        internationalPage = new InternationalPage(WebDriverManager.getDriver());
        singaporePage = new SingaporePage(WebDriverManager.getDriver());
        navigateToCNAInternational();
    }

    @Override
    public String getTestName() {
        return testName;
    }

    @Test(priority = 1,description = "Verify that user is able to crawl through Singapore News")
    public void Automation_Scenario_02() {
        SoftAssert softAssert = new SoftAssert();
        internationalPage.clickOnAllSections();
        internationalPage.clickOnSingapore();
        String actual = singaporePage.getHeaderText();
        assertEquals(softAssert,actual,"Singapore","The Label should be Singapore");
        int initialGridSize = singaporePage.getGridSize();
        singaporePage.clickOnViewMore();
        holdOn(6000);
        int updatedGridSize = singaporePage.getGridSize();
        System.out.println(initialGridSize +"Updated Grid" +updatedGridSize);
        softAssert.assertAll();
    }

}

