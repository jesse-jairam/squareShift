package com.squareshift.pages;

import com.squareshift.utils.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By headline_item = By.xpath("//h1[@class='feature-card__heading feature-card__heading-- h1']/a");


    /**
     * Function Navigates to Channel News Asia Site
     * @return Home Page
     */
    public HomePage navigateToChannelNews(){
       this.driver.get(Settings.getTestUrl());
       return this;
    }


    public String getTextOfNewsHeadline(){
        waitForVisibility(headline_item);
        String text = getText(headline_item);
        return text;
    }

    /**
     * Perform a valid Login
     */
    public NewsDetailsPage clickNewsHeadline(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(headline_item)));
        click(headline_item);
        return new NewsDetailsPage(driver);
    }


}
