package com.qa.test.implementation;

import com.qa.test.hooks.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.support.PageFactory;

public class Registration extends BasePage{

    public Registration() {
        super();  // Calls BasePage constructor which initializes the driver
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static String getTitle(){
        return driver.getTitle();
    }
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private static WebElement nameField;


    /**
     *
     * @param name
     */
    public static void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }


    @AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
    private static WebElement maleOption;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    private static WebElement femaleOption;
    /**
     *
     * @param gender
     */
    public static void setGender(String gender) {
        if(gender.equalsIgnoreCase("female"))
            femaleOption.click();
        else
            maleOption.click();
    }

    @AndroidFindBy(id="android:id/text1")
    private static WebElement countrySelection;

    public static void setCountrySelection(String countryName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countrySelection.click();
        androidUtils.scrollToText(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }


    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private static WebElement shopButton;

    public static void submitButton() {
        shopButton.click();
    }


    public void setActivity()
    {
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
    }
}
