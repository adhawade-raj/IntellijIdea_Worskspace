package com.qa.factory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

public class DriverFactory {
    private static AndroidDriver driver;
    private static Properties prop;

    // Singleton Driver Instance
    public static AndroidDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static void loadConfigProperties() {
        prop = new Properties();
        try {
            String configPath = Paths.get("src", "test", "resources", "testData", "config.properties").toAbsolutePath().toString();
            prop.load(new StringReader(FileUtils.readFileToString(new File(configPath), "UTF-8")));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config properties", e);
        }
    }

    public static void initDriver() {
        loadConfigProperties();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("deviceName"));
        options.setApp(Paths.get("src", "test", "resources", "testData", "General-Store.apk").toAbsolutePath().toString());

        try {
            driver = new AndroidDriver(new URL("http://" + prop.getProperty("ipAddress") + ":" + prop.getProperty("port")), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium Server URL", e);
        }
    }
}
