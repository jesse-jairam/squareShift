package com.squareshift.test;

import com.squareshift.driver.WebDriverManager;
import com.squareshift.pages.NewsDetailsPage;
import com.squareshift.pages.HomePage;
import com.squareshift.utils.JSExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.ITest;

public class Scenario01Test extends TestBase implements ITest {

    private String testName = "Scenario 1 Test";
    HomePage homePage;
    NewsDetailsPage newsDetailsPage;

    @BeforeClass
    public void doInitializations() {
        homePage = new HomePage(WebDriverManager.getDriver());
        newsDetailsPage = new NewsDetailsPage(WebDriverManager.getDriver());
        navigateToCNA();
    }

    @Override
    public String getTestName() {
        return testName;
    }

    @Test(priority = 1,description = "Verify that user is able to login with valid credentials")
    public void Automation_Scenario_01() {
        SoftAssert softAssert = new SoftAssert();
        String actual = homePage.getTextOfNewsHeadline();
        homePage.clickNewsHeadline();
        String expected = newsDetailsPage.getNewsHeadlineText();
        softAssert.assertEquals(actual,expected,"Both should be equal");
        Long last_height = (Long) JSExecutor.getExecutor().executeScript("return document.body.scrollHeight");
        System.out.println(last_height);
        Actions actions = new Actions(WebDriverManager.getDriver());
        while(true){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            holdOn(400);
            try{
                WebElement element = WebDriverManager.getDriver().findElement(By.xpath("(//div[@class='article__read-full-story-button-wrapper'])[2]/a"));
                if(element.isDisplayed()){
                    JSExecutor.getExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
                    holdOn(2000);
                    newsDetailsPage.clickOnReadFullStory();
                    break;
                }       }catch (Exception e1){
                System.out.println("Not Found");
            }
        }

    }

}

