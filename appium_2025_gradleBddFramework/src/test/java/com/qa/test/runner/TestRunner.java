package com.qa.test.runner;

import com.qa.factory.DriverFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.qa.test.steps", "com.qa.test.hooks"},
        plugin = {"pretty","json:target/MyReports/report.json",
                "junit:target/MyReports/report.xml"
                },
        tags = "@Smoke",
        dryRun = false
)
public class TestRunner {

    @BeforeClass
    public static void setup() {
        System.out.println("Initializing Driver...");
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.initDriver();  // Ensure driver initialization is done before tests
    }
}
