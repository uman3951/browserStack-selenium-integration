package com.browserstack.sampleTest;

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

public class MobileTestIntegration2 {
    AppiumDriver driver;
    @BeforeClass
    public void connectToBrowserStack() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"bs");
        capabilities.setCapability(Constants.PLATFORM_NAME, "android");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put(Constants.BUILD_NAME,"Samsung Galaxy S22");
        browserstackOptions.put(Constants.MOBILE_OS_VERSION, "12.0");
        browserstackOptions.put(Constants.MOBILE_DEVICE_NAME, "Samsung Galaxy S22");
        browserstackOptions.put("local", "false");
        // browserstackOptions.put("networkname:applicationName","bs");
        capabilities.setCapability("bstack:options", browserstackOptions);

        driver = new AndroidDriver(new URL("http://192.168.1.6:4444"), capabilities);

    }

    @Test
    public void testGalxyS22(){
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
