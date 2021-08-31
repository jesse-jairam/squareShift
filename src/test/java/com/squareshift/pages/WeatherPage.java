package com.squareshift.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeatherPage extends BasePage {
    /**
     * Constructor
     * @param driver
     */
    public WeatherPage(WebDriver driver) {
        super(driver);
    }

    By label_current_place = By.xpath("//div[@class='info-today__place']");
    By label_max_temp = By.xpath("//span[@class='info-today__temp--max']");
    By label_min_temp = By.xpath("//span[@class='info-today__temp--max']");
    By label_weather_condition = By.xpath(" //div[@class='info-today__condition']");

    /**
     * Get the current place for which temperature is extracted
     * @return current place
     */
    public String getCurrentPlace(){
        return getText(label_current_place);
    }

    /**
     * Extract the maximum temperature
     * @return
     */
    public String getMaxTemp(){
        return getText(label_max_temp);
    }

    /**
     * Extract the minimum temperature
     * @return
     */
    public String getMinTemp(){
        return getText(label_min_temp);
    }

    /**
     *
     * @return
     */
    public String getWeatherCondition(){
        return getText(label_weather_condition);
    }



}
