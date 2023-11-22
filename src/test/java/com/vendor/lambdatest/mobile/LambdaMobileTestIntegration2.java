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

public class LambdaMobileTestIntegration2 {
    AppiumDriver driver;
    @BeforeClass
    public void connectToLambdaTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"lambda");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put(Constants.BUILD, "Samsung Galaxy S22");
        ltOptions.put(Constants.PROJECT, "Samsung Galaxy S22");
        ltOptions.put("w3c", true);
        ltOptions.put(Constants.PLATFORM_NAME, "android");
        ltOptions.put(Constants.MOBILE_DEVICE_NAME, "Galaxy S20");
        ltOptions.put(Constants.MOBILE_PLATFORM_VERSION, "12");
        capabilities.setCapability("lt:options", ltOptions);

        driver = new AndroidDriver(new URL(Constants.HUB_URL), capabilities);

    }

    @Test
    public void testGalaxyS20(){
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
