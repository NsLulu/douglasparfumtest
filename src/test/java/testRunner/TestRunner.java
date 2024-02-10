package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//ludov//Qcentric//douglas-test//feature//open_douglas_homepage.feature",
        glue = "stepDefinitions"
)
public class TestRunner {
}
