package com.squareshift.test;

import com.squareshift.driver.WebDriverManager;
import com.squareshift.pages.AmazonHomePage;
import com.squareshift.pages.InternationalPage;
import com.squareshift.pages.NikeShoesPage;
import com.squareshift.pages.WeatherPage;
import org.testng.ITest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.Set;

public class AmazonScenarioTest extends TestBase implements ITest {

    private String testName = "Amazon Test";
        AmazonHomePage amazonHomePage;
        NikeShoesPage nikeShoesPage;


    @BeforeClass
    public void doInitializations() {
        amazonHomePage = new AmazonHomePage(WebDriverManager.getDriver());
        nikeShoesPage = new NikeShoesPage(WebDriverManager.getDriver());
        navigateToCNA();
    }

    @Override
    public String getTestName() {
        return testName;
    }

    @Test(priority = 1,description = "Verify that user is able to get the weather details of Singapore")
    public void Automation_Scenario_03() {
        SoftAssert softAssert = new SoftAssert();
        amazonHomePage.searchForAnItem("Nike Shoes ");
        holdOn(5000);
        amazonHomePage.clickNikeShoesMen();
        holdOn(5000);
        nikeShoesPage.clickOnThirdShoeLink();
        holdOn(5000);
        String parent = WebDriverManager.getDriver().getWindowHandle();
        Set<String> s = WebDriverManager.getDriver().getWindowHandles();
        // Now iterate using Iterator
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                WebDriverManager.getDriver().switchTo().window(child_window);
            }
        }
        nikeShoesPage.clickOnRedShoeLink();
        nikeShoesPage.clickOnAddToWishList();
        holdOn(10000);
    }
}

