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

public class SourceLabsMobileTestIntegration1 {
    AppiumDriver driver;
    @BeforeClass
    public void connectToSourceLabs() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"sourceLabs");
        capabilities.setCapability(Constants.BROWSER_NAME,"chrome");
        capabilities.setCapability(Constants.PLATFORM_NAME,"android");
        capabilities.setCapability(Constants.APPIUM_PLATFORM_VERSION,"12.0");
        capabilities.setCapability(Constants.APPIUM_DEVICE_NAME,"Samsung Galaxy Tab S7 Plus GoogleAPI Emulator");
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
//        sauceOptions.put(Constants.USER_NAME, "oauth-udara.manupriya-054b4");
//        sauceOptions.put(Constants.USER_NAME, "2fba17e7-bfbd-4027-8c21-bef0f924dda0");
        sauceOptions.put(Constants.BUILD, "Test Samsung");
        sauceOptions.put(Constants.TEST_NAME, "Test Samsung");
        sauceOptions.put("local", "false");
        capabilities.setCapability("sauce:options", sauceOptions);
        driver = new AndroidDriver(new URL("http://192.168.1.10:4444"), capabilities);
    }
    @Test
    public void testGalaxyS7(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }
    @AfterClass
    public void close(){
        driver.quit();
    }


}
