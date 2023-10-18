package com.browserstack.sampleTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidTestGrid {
    @Test
    public void connectToBrowserStack() throws MalformedURLException {
        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> bsOptions = new HashMap<String, Object>();
        bsOptions.put("build", "Test Android");
        bsOptions.put("name", "Testing Integration");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Samsung Galaxy S.*");
        capabilities.setCapability("platformVersion", "1[012]");
        capabilities.setCapability("bstack:options", bsOptions);
         */
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("osVersion", "14.0");
        browserstackOptions.put("deviceName", "Google Pixel 6 Pro");
        browserstackOptions.put("local", "false");
        capabilities.setCapability("bstack:options", browserstackOptions);

        AppiumDriver driver = new AndroidDriver(new URL("http://10.140.38.206:4444"), capabilities);
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
        driver.quit();
    }


}
