package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;



public class DouglasHomepageSteps {


    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is on Douglas homepage")
    public void the_user_is_on_douglas_homepage() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.douglas.de/de");
    }

    @When("the user accepts the cookie consent")
    public void the_user_accepts_the_cookie_consent() {
        // Assuming there's a button for accepting cookies with an identifiable selector
        driver.findElement(By.cssSelector("button.cookie-consent-accept-button")).click();
    }


    @When("the user clicks on the {string} category")
    public void the_user_clicks_on__the_string_category(String category) {
        By categoryLink = By.xpath("//a[contains(text(),'" + category + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(categoryLink)).click();
    }
    @Then("the user should see the PARFUM page")
    public void the_user_should_see_the_parfum_page() {
        // Verify that the URL or page content indicates the PARFUM page
        assert driver.getCurrentUrl().contains("parfum");
        driver.quit();
    }
//    @Then("the user clicks on the {string} category")
//    public void theUserClicksOnTheCategory(String category) {
//        By categoryLink = By.xpath("//a[contains(text(),'" + category + "')]");
//        wait.until(ExpectedConditions.elementToBeClickable(categoryLink)).click();
//    }


}