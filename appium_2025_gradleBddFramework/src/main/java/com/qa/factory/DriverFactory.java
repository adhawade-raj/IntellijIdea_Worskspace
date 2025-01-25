package com.qa.factory;

import com.qa.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {
    AndroidUtils androidUtils;
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

//    public AndroidUtils initializeAndroidUtils(){
//    if(androidUtils == null){
//        androidUtils = new AndroidUtils(getDriver());
//    }
//    return androidUtils;
//    }
    private Properties prop;
    private String fileSeparator = File.separator;
    private String configFilePath = "src/test/resources/testData/config.properties".replace("\\", fileSeparator);
    private String chromeDriverPath = "src/test/resources/testData/chromedriver.exe".replace("\\", fileSeparator);
    private String apkFile = "D:\\Workspace\\IntelliJIdea\\appium_2025_gradleBddFramework\\src\\test\\resources\\testData\\General-Store.apk".replace("\\", fileSeparator);
    private String ipAddress;
    private String port;


    public void initConfigProperties() {
        String configContent = null;
        try {
            configContent = FileUtils.readFileToString(new File(configFilePath), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Load the properties using StringReader
        prop = new Properties();
        try {
            prop.load(new StringReader(configContent));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Retrieve property values
        ipAddress = prop.getProperty("ipAddress");
        System.out.println("IP Address is: " + ipAddress);

        port = prop.getProperty("port");
        System.out.println("Running Port is: " + port);
    }



    /**
     * To Initialize driver and apk file
     *
     * @return
     */

    public void initDriver() {

        initConfigProperties();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("deviceName"));
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        options.setApp(apkFile);

        try {
            System.out.println("Thread ID for setting driver: " + Thread.currentThread().getId());
            driver = new AndroidDriver(new URL("http://" + ipAddress + ":" + port), options);
            System.out.println("Driver set for thread: " + Thread.currentThread().getId());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        androidUtils = new AndroidUtils(driver);
        androidUtils.implicitTimeout(10);
    }


}