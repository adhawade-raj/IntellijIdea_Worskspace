package com.qa.test.hooks;

import com.qa.factory.DriverFactory;
import io.cucumber.java.Before;
import org.junit.BeforeClass;

public class Hooks {

    // Ensure that the setup method is called before any other steps
    @Before
    public static void setup() {
        System.out.println("Initializing Driver...");
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.initDriver();  // Ensure driver initialization is done before tests
    }

}
