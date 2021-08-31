package com.squareshift.pages;

import com.squareshift.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InternationalPage extends BasePage {
    /**
     * Constructor
     * @param driver
     */
    public InternationalPage(WebDriver driver) {
        super(driver);
    }

    By link_all_sections = By.xpath("//span[contains(text(),'All Sections')]");
    By link_top_stories = By.xpath("(//li[@class='hamburger-menu__item hamburger-menu__item--with-sub']/a[text()='Top Stories'])[1]");
    By link_singapore = By.linkText("Singapore");
    By link_weather = By.linkText("Weather");

    public InternationalPage clickOnAllSections() {
        waitForVisibility(link_all_sections);
        click(link_all_sections);
        waitForVisibility(link_top_stories);
        return this;
    }

    public SingaporePage clickOnSingapore() {
        hoverOnElement(link_top_stories);
        waitForVisibility(link_singapore);
        hoverOnElement(link_singapore);
        WebElement ele = WebDriverManager.getDriver().findElement(By.linkText("Singapore"));
        clickByJs(ele);
        return new SingaporePage(driver);
    }

    public WeatherPage clickOnWeather() {
        waitForVisibility(link_weather);
        WebElement ele = WebDriverManager.getDriver().findElement(By.linkText("Weather"));
        clickByJs(ele);
        return new WeatherPage(WebDriverManager.getDriver());
    }




}
