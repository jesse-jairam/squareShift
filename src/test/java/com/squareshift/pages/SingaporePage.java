package com.squareshift.pages;

import com.squareshift.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingaporePage extends BasePage {
    /**
     * Constructor
     * @param driver
     */
    public SingaporePage(WebDriver driver) {
        super(driver);
    }

    By label_first_header = By.xpath("//h1/span");
    By grid_container = By.xpath("//div[contains(@class,'grid-cards-four-column')]");
    By button_view_more = By.id("stories-infinte-scroll");

    /**
     * Click on the View More Button
     * @return
     */
    public SingaporePage clickOnViewMore() {
        waitForVisibility(button_view_more);
        click(button_view_more);
        return this;
    }

    public String getHeaderText(){
        return getText(label_first_header);
    }

    public int getGridSize(){
        return WebDriverManager.getDriver().findElements(grid_container).size();
    }

}
