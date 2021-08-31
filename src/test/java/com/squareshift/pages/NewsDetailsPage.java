package com.squareshift.pages;

import com.squareshift.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsDetailsPage extends BasePage {
    /**
     * Constructor
     * @param driver
     */
    public NewsDetailsPage(WebDriver driver) {
        super(driver);
    }

    By label_news_details = By.xpath("//h1[@class='h1 h1--page-title']");
    By full_story_button = By.xpath("(//div[@class='article__read-full-story-button-wrapper'])[2]/a");

    public String getNewsHeadlineText() {
        waitForVisibility(label_news_details);
        String text = getText(label_news_details);
        return text;
    }

    public NewsDetailsPage clickOnReadFullStory(){
        WebElement element = WebDriverManager.getDriver().findElement(full_story_button);
        clickByJs(element);
        return this;
    }

}
