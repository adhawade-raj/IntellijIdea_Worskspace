package com.qa.utils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidUtils {

    private AndroidDriver driver;

    public AndroidUtils(AndroidDriver driver) {
        this.driver = driver;
    }

    public void threadSleep(int value) {
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void implicitTimeout(int implicitTimeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeout));
    }


    public void pageLoadTimeout(int pageLoadTimeout) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
    }


    public String getScreenshotPath(String testCaseName, AndroidDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
        // 1. capture and place in folder //2. extent report pick file and attach to
        // report
    }


    /**
     *
     * @param Productcount
     * @param productName
     */
    public void addToCart(int Productcount, String productName) {

        for(int i=0; i<Productcount; i++) {
            String productNames = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if(productNames.equalsIgnoreCase(productName)) {
                System.out.println("Product Name on Page : "+productNames);

                driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"]")).get(i).click();
            }
        }
    }


    /**
     *
     * @param ele
     */
    public void longPressAction(WebElement ele)
    {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "duration",2000));
    }

    /**
     *
     */
    public void scrollToEndAction()
    {
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0

            ));
        }while(canScrollMore);
    }



    public void scrollToText(String text)
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }

    /**
     *
     * @param ele
     * @param direction
     */
    public void swipeAction(WebElement ele,String direction)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),

                "direction", direction,
                "percent", 0.75
        ));


    }

    /**
     *
     * @param amount
     * @return
     */
    public Double getFormattedAmount(String amount)
    {
        Double price = Double.parseDouble(amount.substring(1));
        return price;

    }

}