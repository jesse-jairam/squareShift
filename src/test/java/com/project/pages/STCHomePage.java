package com.project.pages;

import com.project.utils.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class STCHomePage extends BasePage{

    public STCHomePage(WebDriver driver) {
        super(driver);
    }

    By button_english = By.xpath("//a[@id='translation-btn']");
    By label_uae = By.id("ae");
    By label_egypt = By.id("eg");
    By label_algeria = By.id("dz");
    By link_country_selector = By.id("country-btn");

    public STCHomePage navigateToSite(){
        this.driver.get(Settings.getTestUrl());
        return this;
    }
    public STCHomePage clickOnEnglish(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(button_english)));
        click(button_english);
        return this;
    }
    public STCHomePage clickCountrySelector(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(link_country_selector)));
        click(link_country_selector);
        return this;
    }

    public STCHomePage clickUAE(){
        waitForVisibility(label_uae);
        click(label_uae);
        return this;
    }
    public STCHomePage clickAlgeria(){
        waitForVisibility(label_algeria);
        click(label_algeria);
        return this;
    }
    public STCHomePage clickEgypt(){
        waitForVisibility(label_egypt);
        click(label_egypt);
        return this;
    }

    public List<String> getTypes(){
        List<String> textList = new ArrayList<String>();
        List<WebElement> typeList = driver.findElements(By.xpath("//strong[contains(@id,'name-')]"));
        for ( WebElement element: typeList) {
            {
                textList.add(element.getText());
            }
        }
        return textList;
    }

    public List<String> getPrice(){
        List<String> textList = new ArrayList<String>();
        List<WebElement> typeList = driver.findElements(By.xpath("//div[@class='price']"));
        for ( WebElement element: typeList) {
            {
                textList.add(element.getText());
            }
        }
        return textList;
    }

    public List<String> getOldPrice(){
        List<String> textList = new ArrayList<String>();
        List<WebElement> typeList = driver.findElements(By.xpath("//div[@class='old-price']"));
        for ( WebElement element: typeList) {
            {
                textList.add(element.getText());
            }
        }
        return textList;
    }

    public HashMap<String, String> getPlanAndPrice()
    {
        List<String> header = getTypes();
        List<String> headerValue = getPrice();

        HashMap<String, String> headDetails = new HashMap<>();
        for (int i = 0; i < header.size(); i++)
        {
            headDetails.put(header.get(i), headerValue.get(i));
        }

        return headDetails;
    }

}
