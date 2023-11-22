package com.vendor.sourcelabs.mobile;

import com.common.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SourceLabsMobileAppTest {
    AppiumDriver driver;
    @BeforeClass
    public void connectToSourceLabs() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"sourceLabs");
        capabilities.setCapability(Constants.PLATFORM_NAME,"android");
        capabilities.setCapability(Constants.APPIUM_PLATFORM_VERSION,"12.0");
        capabilities.setCapability(Constants.APPIUM_DEVICE_NAME,"Samsung Galaxy Tab S7 Plus GoogleAPI Emulator");
        capabilities.setCapability("app", "storage:28a2e6f6-713a-492c-a01f-a9088ebaf7f7");
        //set capabilities.setCapability("browserName", "") for virtual devices
         capabilities.setCapability("browserName", "");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put(Constants.BUILD, "Test Mobile App");
        sauceOptions.put(Constants.TEST_NAME, "Test Mobile App");
        sauceOptions.put("local", "false");
        capabilities.setCapability("sauce:options", sauceOptions);
        driver = new AndroidDriver(new URL(Constants.HUB_URL), capabilities);
    }
    @Test
    public void testAndroidApp(){
    }
    @AfterClass
    public void close(){
        driver.quit();
    }


}
