package com.ludovic.douglas.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static sun.awt.SunToolkit.DEFAULT_WAIT_TIME;

public class BasePage {

    //    WebDriver driver;
    protected static RemoteWebDriver driver;

    /*    public BasePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }*/

//    System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
