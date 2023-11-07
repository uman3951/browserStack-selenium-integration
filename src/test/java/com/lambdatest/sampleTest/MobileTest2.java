package com.lambdatest.sampleTest;

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

public class MobileTest2 {
    AppiumDriver driver;
    @BeforeClass
    public void connectToLambdaTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put(Constants.BUILD_NAME, "Test Mobile Lambda2");
        ltOptions.put(Constants.PROJECT_NAME, "Test Mobile Lambda2");
        ltOptions.put("w3c", true);
        ltOptions.put(Constants.PLATFORM_NAME, "android");
        ltOptions.put(Constants.MOBILE_DEVICE_NAME, "Pixel 6 Pro");
        ltOptions.put(Constants.MOBILE_PLATFORM_VERSION, "13");
        capabilities.setCapability("lt:options", ltOptions);

        driver = new AndroidDriver(new URL("https://udara.manupriya:Ejvwi0FShhVeYpQW2fUwemw88y2DzBbiwFCWdQqYXck9T8WUcM@hub.lambdatest.com/wd/hub"), capabilities);

    }

    @Test
    public void TestSourceDemoGooglePixelPro(){
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
