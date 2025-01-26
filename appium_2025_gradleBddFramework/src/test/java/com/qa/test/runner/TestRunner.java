package com.qa.test.runner;

import com.qa.factory.DriverFactory;
import com.qa.test.hooks.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    static final Logger logger = LogManager.getLogger(TestRunner.class);

    @BeforeClass
    public static void setup() {

        System.setProperty("log4j.configurationFile", "src/test/resources/log4j.properties");
        PropertyConfigurator.configure(System.getProperty("log4j.configurationFile"));

        logger.info("******** Initializing Driver ********");
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.initDriver();  // Ensure driver initialization is done before tests
    }
}
