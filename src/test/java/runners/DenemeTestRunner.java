package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions"},
        dryRun = false
)


public class DenemeTestRunner extends AbstractTestNGCucumberTests {
}
