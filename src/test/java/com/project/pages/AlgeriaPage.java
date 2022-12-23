package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlgeriaPage extends BasePage{

    public AlgeriaPage(WebDriver driver) {
        super(driver);
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

    public HashMap<String, String> getPlanAndPrice(List<String> header,List<String> headerValue)
    {
        HashMap<String, String> headDetails = new HashMap<>();
        for (int i = 0; i < header.size(); i++)
        {
            headDetails.put(header.get(i), headerValue.get(i));
        }

        return headDetails;
    }

}
