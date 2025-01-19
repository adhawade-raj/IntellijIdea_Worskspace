package com.qa.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Corrected path for features
        glue = {"com.qa.test.stepDefinations", "com.qa.test.hooks"}, // Corrected glue paths
        plugin = {"pretty"},
        tags = "@Smoke",
        dryRun = false // Set to true for a dry run to validate steps without execution
)
public class TestRunner {
}
