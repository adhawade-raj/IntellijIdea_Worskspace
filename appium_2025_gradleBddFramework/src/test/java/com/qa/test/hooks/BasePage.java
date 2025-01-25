package com.qa.test.hooks;

import com.qa.factory.DriverFactory;
import com.qa.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    protected static AndroidDriver driver;
    DriverFactory driverFactory;
    public static AndroidUtils androidUtils;

    // Constructor should not use 'this' driver, use the static driver from DriverFactory
    public BasePage() {
        if (driver == null) {
            driver = DriverFactory.getDriver();  // Ensure the driver is fetched from the factory
            System.out.println("Driver fetched in BasePage: " + (driver != null));  // Debug log
        }

        if (driver == null) {
            throw new RuntimeException("Driver is not initialized. Please check your setup.");
        }

        // Initialize the page elements
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        androidUtils = new AndroidUtils(driver);
    }
}