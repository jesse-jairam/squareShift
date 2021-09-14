package com.squareshift.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NikeShoesPage extends BasePage {
    /**
     * Constructor
     * @param driver
     */
    public NikeShoesPage(WebDriver driver) {
        super(driver);
    }

    By label_nike_third_shoe= By.xpath("(//div[@class='a-section aok-relative s-image-tall-aspect'])[3]");
    By label_red_shoes = By.xpath("//img[@src='https://m.media-amazon.com/images/I/41xLeHrGTtL._SS47_.jpg']");
    By link_add_to_wish_list = By.xpath("//a[@title='Add to Wish List']");
    /**
     * Get the current place for which temperature is extracted
     * @return current place
     */
    public NikeShoesPage clickOnThirdShoeLink(){
        scrollToElement(label_nike_third_shoe);
        click(label_nike_third_shoe);
        return this;
    }

    public NikeShoesPage clickOnRedShoeLink(){
        scrollToElement(label_red_shoes);
        click(label_red_shoes);
        return this;
    }

    public NikeShoesPage clickOnAddToWishList(){
        click(link_add_to_wish_list);
        return this;
    }

}
