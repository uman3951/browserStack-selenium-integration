package com.sourcelabs.sampleTest;

import com.common.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class MobileTest1 {
    AppiumDriver driver;
    @BeforeClass
    public void connectToSourceLabs() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("networkname:applicationName","sourceLabs");
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("appium:platformVersion","12.0");
        //capabilities.setCapability("browserVersion","11");
        capabilities.setCapability("appium:deviceName","Google Pixel 6 GoogleAPI Emulator");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put(Constants.SOURCE_LABS_USER_NAME, "oauth-udara.manupriya-054b4");
        sauceOptions.put(Constants.SOURCE_LABS_ACCESS_KEY, "2fba17e7-bfbd-4027-8c21-bef0f924dda0");
        sauceOptions.put(Constants.BUILD_NAME, "Test Samsung");
        sauceOptions.put(Constants.TEST_NAME, "Testing Samsung");
         sauceOptions.put("local", "false");
        //capabilities.setCapability("networkname:applicationName","sourceLabs");
        capabilities.setCapability("sauce:options", sauceOptions);

        driver = new AndroidDriver(new URL("http://192.168.1.6:4444"), capabilities);
    }
    @Test
    public void TestSourceDemoGooglePixelPro(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
    @AfterClass
    public void close(){
        driver.quit();
    }


}
