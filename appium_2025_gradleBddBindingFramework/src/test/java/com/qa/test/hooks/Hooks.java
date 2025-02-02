package com.qa.test.hooks;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.qa.factory.DriverFactory;
import com.qa.test.config.TestModule;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;

public class Hooks {

    private static Injector injector;
    static final Logger logger = LogManager.getLogger(Hooks.class);

    @BeforeClass
    public static void setup() {
        injector = Guice.createInjector(new TestModule());
        logger.info("******** Initializing Driver ********");
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.initDriver();  // Ensure driver initialization is done before tests
    }

//    @Before()
//    public void guiceSetup(){
//        injector = Guice.createInjector(new TestModule());
//    }

}
