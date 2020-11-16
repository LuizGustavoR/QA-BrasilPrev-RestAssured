package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"steps"},
        features = "src/test/resources/features/",
        plugin = "json:target/cucumber-report.json")
public class RunCucumberTests extends AbstractTestNGCucumberTests {}