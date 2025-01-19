package com.qa.test.hooks;

import com.qa.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;

public class BaseTest {
    AndroidDriver driver;
    AndroidUtils androidUtils;

    @Before
    public void initDriver() {
        System.out.println("Initializing driver...");
        androidUtils = new AndroidUtils(driver);
        driver = androidUtils.initDriver();
    }
}
