package com.base.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtils {

    public WebDriverUtils(WebDriver driver){
        this.driver = driver;
    }
    private static final int WAIT_IN_SECONDS = 10;

    private WebDriver driver;

    public void waitForElementToBePresent(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_IN_SECONDS)).until(ExpectedConditions.visibilityOf(element));
    }
    
}
