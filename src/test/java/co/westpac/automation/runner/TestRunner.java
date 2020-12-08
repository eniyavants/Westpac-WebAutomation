package co.westpac.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        strict = true,
        features = "classpath:features/",
        glue = {"co.westpac.automation.stepdefinitions"},
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber"})
public class TestRunner {

}