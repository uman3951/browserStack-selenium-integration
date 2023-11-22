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

public class SourceLabsMobileTestIntegration3 {
   // IOSDriver driver;
   AppiumDriver driver;
    @BeforeClass
    public void connectToSourceLabs() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"sourceLabs");
        capabilities.setCapability(Constants.BROWSER_NAME,"safari");
        capabilities.setCapability(Constants.PLATFORM_NAME,"iOS");
        capabilities.setCapability(Constants.APPIUM_PLATFORM_VERSION, "16.3");
        capabilities.setCapability(Constants.APPIUM_DEVICE_NAME, "iPhone XR");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put(Constants.BUILD, "Test iPhone");
        sauceOptions.put(Constants.TEST_NAME, "Test iPhone");
        sauceOptions.put("local", "false");
        capabilities.setCapability("sauce:options", sauceOptions);
        driver = new IOSDriver(new URL(Constants.HUB_URL), capabilities);
    }
    @Test
    public void testiPhone7(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
    @AfterClass
    public void close(){
        driver.quit();
    }


}
