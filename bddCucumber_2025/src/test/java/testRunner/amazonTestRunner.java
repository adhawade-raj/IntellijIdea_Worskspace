package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/Search.feature",
        glue = "org.stepDefinations",
        plugin = {
        "pretty" }, // Ensures that the output is printed to the console
        strict = true)

public class amazonTestRunner {
}
