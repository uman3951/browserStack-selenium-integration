package com.vendor.sourcelabs.mobile;

import com.common.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SourceLabsiOSAppTest {
   // IOSDriver driver;
   AppiumDriver driver;
    @BeforeClass
    public void connectToSourceLabs() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"sourceLabs");
        capabilities.setCapability(Constants.PLATFORM_NAME,"iOS");
        capabilities.setCapability(Constants.APPIUM_PLATFORM_VERSION, "16.7");
        capabilities.setCapability(Constants.APPIUM_DEVICE_NAME, "iPhone XR");
        capabilities.setCapability("app", "storage:5da55bc4-a86e-48f6-ac83-bd67066e1cae");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put(Constants.USER_NAME, "tipuman3951");
        sauceOptions.put(Constants.USER_NAME, "91b57790-aa4c-4f76-b39a-c06d2aa60586");
        sauceOptions.put(Constants.BUILD, "Test ios App");
        sauceOptions.put(Constants.TEST_NAME, "Test ios App");
        sauceOptions.put("local", "false");
        capabilities.setCapability("sauce:options", sauceOptions);
        driver = new IOSDriver(new URL(Constants.HUB_URL), capabilities);
    }
    @Test
    public void testiPhone7(){
    }
    @AfterClass
    public void close(){
        driver.quit();
    }


}
