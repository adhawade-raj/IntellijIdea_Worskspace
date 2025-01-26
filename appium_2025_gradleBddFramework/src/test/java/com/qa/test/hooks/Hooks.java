package com.qa.test.hooks;

import com.qa.factory.DriverFactory;
import com.qa.test.runner.TestRunner;
import io.cucumber.java.Before;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;

public class Hooks {

    static final Logger logger = LogManager.getLogger(Hooks.class);

    @BeforeClass
    public static void setup() {

        System.setProperty("log4j.configurationFile", "src/test/resources/log4j.properties");
        PropertyConfigurator.configure(System.getProperty("log4j.configurationFile"));

        logger.info("******** Initializing Driver ********");
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.initDriver();  // Ensure driver initialization is done before tests
    }

}
