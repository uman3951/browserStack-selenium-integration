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
        capabilities.setCapability(Constants.APPIUM_PLATFORM_VERSION, "16.3");
        capabilities.setCapability(Constants.APPIUM_DEVICE_NAME, "iPhone XR");
        capabilities.setCapability("app", "storage:779aa95e-0384-4838-be45-182f7c829215");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put(Constants.USER_NAME, "oauth-udara.manupriya-054b4");
        sauceOptions.put(Constants.USER_NAME, "2fba17e7-bfbd-4027-8c21-bef0f924dda0");
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
