package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty", "html:target/cucumbe-reports.html"},
        monochrome = true
)

public class TestNGRunnerTests extends AbstractTestNGCucumberTests {
}
