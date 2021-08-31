package com.squareshift.pages;

import com.squareshift.utils.JSExecutor;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static Logger log;

    /**
     * Constructor
     *
     * @param d
     */
    public BasePage(WebDriver d) {
        this.driver = d;
        wait = new WebDriverWait(driver, 30);
        log = Logger.getLogger(BasePage.class.getName());
    }

    /**
     * @param elementBy
     * @param text      to be written to the element
     */
    public void writeText(By elementBy, String text) {
        driver.findElement(elementBy).sendKeys(text);
    }

    public void clearText(By elementBy) {
        driver.findElement(elementBy).clear();
    }

    public void setValuebyCharacter(By elementBy, String newValue) {
        for (int i = 0; i < newValue.length(); i++) {
            char character = newValue.charAt(i);
            String str = new StringBuilder().append(character).toString();
            holdOn(1000);
            driver.findElement(elementBy).sendKeys(str);
        }
    }

    /**
     * This function clicks on an element
     *
     * @param elementBy
     */
    public void click(By elementBy) {
        driver.findElement(elementBy).click();
        log.info("Clicked on the Element" +elementBy);
    }

    public String getText(By elementBy) {
        String text = "";
        text = driver.findElement(elementBy).getText();
        log.info("The text extracted is " +text);
        return text;
    }

    public void hoverOnElement(By elementBy) {
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(elementBy);
        actions.moveToElement(menuOption).perform();
        holdOn(1000);
        log.info("Hovered on Element " +elementBy);
    }

    public void clickByJs(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * @return the title of the page
     */
    public String getTitle() {
        return driver.getTitle();
    }

    //Wait Wrapper Method
    public void waitForVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitForDisappear(By elementBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    /**
     * https://stackoverflow.com/questions/44587164/select-randomly-from-dropdown-list
     * selects a random item from a dropdown
     */
    public void selectRandomDropdownItem(By elementBy) {
        WebElement drpDwnList = driver.findElement(elementBy);
        Select objSel = new Select(drpDwnList);
        List<WebElement> weblist = objSel.getOptions();
        int iCnt = weblist.size();
        Random num = new Random();
        int iSelect = num.nextInt(iCnt);
        objSel.selectByIndex(iSelect);
    }

    public String getSelectedItem(By elementBy) {
        Select select = new Select(driver.findElement(elementBy));
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText();
        return defaultItem;
    }

    public void selectRandomWebelement(By elementBy) {
        List<WebElement> list = driver.findElements(elementBy);
        list.get(getRandomNumberInBetween(1, list.size() - 1)).click();
    }

    private int getRandomNumberInBetween(int lowerBound, int upperBound) {
        Random r = new Random();
        return (r.nextInt(upperBound) + lowerBound);
    }

    public void tabOut(By elementBy) {
        driver.findElement(elementBy).sendKeys(Keys.TAB);
    }

    public String getCurrentDate() {
        return LocalDate.now()
                .toString();
    }

    protected static void holdOn(Integer millis) {
        log.debug("Sitting for " + millis + " milliseconds.");
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scroll till the element is visible
     */
    public void scrollToElement(By element) {
        WebElement webelement = driver.findElement(element);
        JSExecutor.getExecutor().executeScript("arguments[0].scrollIntoView(true);", webelement);
    }
}
