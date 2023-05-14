package com.base.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
//    public HomePage(){
//
//    }
    @FindBy(xpath = "//*[@id=\"L2AGLb\"]/div")
    private WebElement consent;
    @FindBy(className = "gLFyf")
    private WebElement searchBox;
    @FindBy(id = "search")
    private WebElement search;
    public void giveConsent() { consent.click(); }
    public void searchFor(String searchTerm) {
        searchBox.sendKeys(searchTerm);
    }
    public void clickSearchButton() {
        searchBox.submit();
    }
    public void waitForPageToLoad() {
        waitForElementToBePresent(search);
    }
}
