package com.ludovic.douglas.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static sun.awt.SunToolkit.DEFAULT_WAIT_TIME;

public class BasePage {

    protected static RemoteWebDriver driver;
    protected WebDriverWait wait;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    protected boolean isElementPresent(By by) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    private void waitVisibility(WebElement element, boolean clickable) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.withTimeout(Duration.ofSeconds(5));
        try {
            if (clickable) {
                wait.until(ExpectedConditions.elementToBeClickable(element));
            } else {
                wait.until(ExpectedConditions.visibilityOf(element));
            }
        } catch (NoSuchElementException exception) {
            throw new RuntimeException("This element is not visible within given duration: " + element);
        }
    }

    public void waitElementToBeVisible(WebElement element) {
        waitVisibility(element, false);
    }

    public void waitElementToBeClickable(WebElement element) {
        waitVisibility(element, true);
    }

    public void verifyVisibilityOfElement(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        if (element.isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);  // Reset implicit wait
        } else {
            throw new RuntimeException("Element is not visible: " + locator);
        }
    }

    public WebElement waitForVisibilityOfElementLocated(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void click(WebElement element) {
        waitElementToBeClickable(element);
        element.click();
    }
}
