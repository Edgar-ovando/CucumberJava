package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = ".//features/Login.feature",
                glue = "tests",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty", "html:test-output"}

        )
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
