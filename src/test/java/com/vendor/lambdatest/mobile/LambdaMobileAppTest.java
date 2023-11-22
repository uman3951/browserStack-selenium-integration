/**
 * This is the latest implementation
 */
package com.vendor.lambdatest.mobile;

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

public class LambdaMobileAppTest {
    AppiumDriver driver;
    @BeforeClass
    public void connectToLambdaTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"lambda");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put(Constants.BUILD, "Test Mobile App Lambda");
        ltOptions.put(Constants.PROJECT, "Test Mobile App Lambda");
        ltOptions.put("w3c", true);
        ltOptions.put("isRealMobile","true");
        ltOptions.put("app","lt://<>id");
        ltOptions.put(Constants.PLATFORM_NAME, "android");
        ltOptions.put(Constants.MOBILE_DEVICE_NAME, "Pixel 6 Pro");
        ltOptions.put(Constants.MOBILE_PLATFORM_VERSION, "13");
        capabilities.setCapability("lt:options", ltOptions);
        driver = new AndroidDriver(new URL(Constants.HUB_URL), capabilities);
    }

    @Test
    public void testGooglePixel(){
    }

    @AfterClass
    public void close(){
        driver.quit();
    }

}
