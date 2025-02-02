package com.qa.test.config;

import com.google.inject.AbstractModule;
import com.qa.factory.DriverFactory;
import com.qa.test.implementation.Registration;
import com.qa.utils.AndroidUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AppiumDriver.class).toInstance(DriverFactory.getDriver());
        bind(Registration.class);

        bind(AndroidDriver.class).toInstance(DriverFactory.getDriver()); // Injects the Driver
        bind(AndroidUtils.class).toInstance(new AndroidUtils(DriverFactory.getDriver())); // Utility Injection

    }

}
