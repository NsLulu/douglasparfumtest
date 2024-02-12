package com.ludovic.douglas.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com/ludovic/douglas"},
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber-report/cucumber.json", "junit:target/cucumber-report/cucumber.xml"}
)

public class TestRunner {

}
