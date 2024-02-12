package com.ludovic.douglas.ui.home;

import com.ludovic.douglas.managers.DriverManager;
import com.ludovic.douglas.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

//public class HomePage {
public class HomePage extends BasePage{
//    public HomePage(WebDriver driver) {
//        super(driver);
//    }
    private HomePageLocator homePageLocator;
    private final Map<String, String> xpathToButton = HomePageLocator.createLibraryButton();
    private final Map<String, String> xpathToElement = HomePageLocator.createLibraryElement();

    public HomePage(RemoteWebDriver driver, HomePageLocator homePageLocator) {
        super(driver);
        this.homePageLocator = homePageLocator;
    }

    public void navigateTo(String url) {
        System.out.println("Navigating to: " + url);
        driver.get(url);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
        System.out.println("Navigation complete.");
    }
    public static HomePage initializeHomePage(String browser) {
        RemoteWebDriver driver = DriverManager.getDriver(browser);
        HomePageLocator homePageLocator = new HomePageLocator();
        return new HomePage(driver, homePageLocator);
    }

    public void handleCookieConsent(String button) {
        if (isElementPresent(By.tagName("iframe"))) {
            WebElement iframe = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframe);
        }
        String buttonXPath = xpathToButton.get(button);
        WebElement buttonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonXPath)));
        click(buttonElement);
//        driver.findElement(By.xpath("//button[@class='button button__primary uc-list-button__accept-all']")).click();
//        driver.switchTo().defaultContent();
    }

    public void homePageTab(String button) {
        String tabXPath = xpathToButton.get(button);
        WebElement tabElement = driver.findElement(By.xpath(tabXPath));
        click(tabElement);
    }
    public void verifyElement(String element) {
        String locator = xpathToElement.get(element);
        verifyVisibilityOfElement(locator);
    }
    public void verifyAccountDetailPage() {
        String pageTitle = xpathToElement.get("xxx page title");
        waitForVisibilityOfElementLocated(By.xpath(pageTitle));
    }

    public void clickParfumLink() {
               String parfumLinkXPath = homePageLocator.getParfumLinkXPath();
            // Click on the 'Parfum' link using the XPath
    }


}
