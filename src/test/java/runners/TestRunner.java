package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"testSteps", "hooks"},
        plugin = {"pretty","junit:target/junitreport.xml","json:target/jsonreport.json","html:target/cucumber-reports"},
        monochrome = true,
        tags = "not @skip")
public class TestRunner {
}
