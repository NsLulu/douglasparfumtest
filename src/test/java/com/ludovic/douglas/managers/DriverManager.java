package com.ludovic.douglas.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    private static RemoteWebDriver driver;

    public static RemoteWebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    options.addArguments("allow-running-insecure-content");
                    options.addArguments("--ignore-certificate-errors");
                    options.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();

                    driver = new ChromeDriver(options);
//                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "C:/Program Files/Google/Firefox/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver", "C:/Program Files/Google/Edge/msedgedriver.exe");
                    EdgeOptions option = new EdgeOptions();
                    option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                    option.addArguments("--remote-allow-origins=*");
                    option.addArguments("start-maximized");

                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(option);

//                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}