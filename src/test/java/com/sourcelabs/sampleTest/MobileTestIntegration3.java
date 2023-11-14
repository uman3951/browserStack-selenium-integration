package com.sourcelabs.sampleTest;

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

public class MobileTestIntegration3 {
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
        sauceOptions.put(Constants.SOURCE_LABS_USER_NAME, "oauth-udara.manupriya-054b4");
        sauceOptions.put(Constants.SOURCE_LABS_ACCESS_KEY, "2fba17e7-bfbd-4027-8c21-bef0f924dda0");
        sauceOptions.put(Constants.BUILD, "Test iPhone");
        sauceOptions.put(Constants.TEST_NAME, "Test iPhone");
        sauceOptions.put("local", "false");
        capabilities.setCapability("sauce:options", sauceOptions);
        driver = new IOSDriver(new URL("http://192.168.1.6:4444"), capabilities);
    }
    @Test
    public void TestiPhone7(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
    @AfterClass
    public void close(){
        driver.quit();
    }


}
