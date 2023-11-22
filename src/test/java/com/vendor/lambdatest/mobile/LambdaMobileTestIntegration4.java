package com.vendor.lambdatest.mobile;

import com.common.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class LambdaMobileTestIntegration4 {
    AppiumDriver driver;
    @BeforeClass
    public void connectToLambdaTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"lambda");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put(Constants.BUILD, "Test Mobile iOS");
        ltOptions.put(Constants.PROJECT, "Test Mobile iOS");
        ltOptions.put("w3c", true);
        ltOptions.put(Constants.PLATFORM_NAME, "iOS");
        ltOptions.put(Constants.MOBILE_DEVICE_NAME, "iPhone 7");
        ltOptions.put(Constants.MOBILE_PLATFORM_VERSION, "10.3");
        capabilities.setCapability("lt:options", ltOptions);

        driver = new IOSDriver(new URL("http://192.168.1.6:4444"), capabilities);

    }

    @Test
    public void testiPhone7(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getTitle(), "Test");
    }

    @AfterClass
    public void close(){
        driver.quit();
    }

}
