package com.squareshift.pages;

import com.squareshift.utils.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonHomePage extends BasePage{

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    By textbox_search = By.id("twotabsearchtextbox");
    By label_nikemen = By.xpath("//*[contains(@id,'searchAjax')]//span[text()='men']/..");


    /**
     * Function Navigates to Channel News Asia Site
     * @return Home Page
     */
    public AmazonHomePage navigateToAmazon(){
       this.driver.get(Settings.getTestUrl());
       return this;
    }


    public AmazonHomePage searchForAnItem(String item){
        waitForVisibility(textbox_search);
        writeText(textbox_search,item);
        holdOn(2000);
        return this;
    }


    public NikeShoesPage clickNikeShoesMen(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(label_nikemen)));
        hoverOnElement(label_nikemen);
        click( label_nikemen);
        return new NikeShoesPage(driver);
    }


}
