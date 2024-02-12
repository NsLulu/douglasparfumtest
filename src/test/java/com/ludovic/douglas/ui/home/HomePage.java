package com.ludovic.douglas.ui.home;

import com.ludovic.douglas.managers.DriverManager;
import com.ludovic.douglas.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Map;

//public class HomePage {
public class HomePage extends BasePage{
//    public HomePage(WebDriver driver) {
//        super(driver);
//    }
    private final HomePageLocator homePageLocator;

/*    public HomePage() {
            this.homePageLocator = new HomePageLocator();
        }*/

    private final Map<String, String> xpathToButton = HomePageLocator.createLibraryButton();
    private final Map<String, String> xpathToElement = HomePageLocator.createLibraryElement();

    public HomePage(RemoteWebDriver driver, HomePageLocator homePageLocator) {
        super(driver);
        this.homePageLocator = homePageLocator;
    }

    public void navigateTo(String url) {
        //driver.get(url);
        System.out.println("Navigating to: " + url);
        driver.get(url);
        System.out.println("Navigation complete.");
    }

    public void handleCookieConsent(String button) {
        xpathToButton.get(button);
    }

    public void homePageTab(String button) {
        xpathToButton.get(button);
    }
    public void verifyElement(String element) {
        String locator = xpathToElement.get(element);
        verifyVisibilityOfElement(locator);
    }
    public void verifyAccountDetailPage() {
        String pageTitle = xpathToElement.get("page title");
        waitForVisibilityOfElementLocated(By.xpath(pageTitle));
    }

    public void clickParfumLink() {
               String parfumLinkXPath = homePageLocator.getParfumLinkXPath();
            // Click on the 'Parfum' link using the XPath
    }


}
