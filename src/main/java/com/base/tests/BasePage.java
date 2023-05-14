package com.base.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage{
    protected BasePage(){
        WebDriverManager.chromedriver().setup();
        System.out.println("creating object webDriver here");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        init();
    }
    protected WebDriver driver;

    protected WebDriverUtils webDriverUtils;

    public void init() {
        PageFactory.initElements(driver, this);
        webDriverUtils = new WebDriverUtils(this.driver);
    }

    protected void waitForThenClick(WebElement element) {
        try {
            webDriverUtils.waitForElementToBePresent(element);
            element.click();
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, this);
            element.click();
        }
    }

    public void openURL(String url) {
        driver.get(url);
    }

    protected void waitForElementToBePresent(WebElement element) {
        try {
            webDriverUtils.waitForElementToBePresent(element);
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, this);
            webDriverUtils.waitForElementToBePresent(element);
        }
    }

    public void tearDown(){
        if (null != driver){
            driver.quit();
        }
    }
}
