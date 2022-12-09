package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"StepDefinition"},
        plugin = {"json:target/cucumber-report/cucumber.json",
                "pretty", "html:target/cucumber-reports.html"})
public class Runner {
}
