package com.ludovic.douglas.ui.home;

import java.util.HashMap;
import java.util.Map;

public class HomePageLocator {

    public static Map<String, String> createLibraryButton() {
        Map<String, String> xpathToButton = new HashMap<>();
        xpathToButton.put("acceptcookies", "//button[@class='button button__primary uc-list-button__accept-all']");
        xpathToButton.put("PARFUM", "//a[@href='/de/c/parfum/01']");
        return xpathToButton;
    }

    public static Map<String,String> createLibraryElement() {
        Map<String, String> xpathToElement = new HashMap<>();
        xpathToElement.put("Parfüm & Düfte", "//h1[contains(text(), 'Parfüm & Düfte')]");
        return xpathToElement;
    }

    public String getParfumLinkXPath() {
        //return createLibraryButton().get("ParfumLink");
        return null;
    }
}
