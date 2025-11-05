package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue =  {"stepDefinitions", "hooks"},
        tags = "@Regression",
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome=true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
