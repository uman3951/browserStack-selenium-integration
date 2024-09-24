/**
 * This is the latest implementation
 */
package com.vendor.browserstack.mobile;

import com.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BsMobileAppTestNew {
    RemoteWebDriver driver;
    @BeforeClass
    public void connectToBrowserStack() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"bs");
        capabilities.setCapability("device:platform", "android");
        capabilities.setCapability("appium:deviceName", "Google Pixel 6 Pro");
        //capabilities.setCapability("appium:app", "bs://8407e5ee4bd61f88b2f8bad0962e15d2444b2e6b");
        capabilities.setCapability("appium:app", "bs://125574196145a2c5623c31d1d82551874cf0f384");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put(Constants.BUILD_NAME,"Test Mobile 1");
        browserstackOptions.put(Constants.PROJECT_NAME,"test");
       // browserstackOptions.put(Constants.MOBILE_OS_VERSION, "13.0");
       // browserstackOptions.put("appium:deviceName", "Google Pixel 6 Pro");
      //  browserstackOptions.put("local", "false");
        capabilities.setCapability("bstack:options", browserstackOptions);
        driver = new RemoteWebDriver(new URL(Constants.HUB_URL), capabilities);
    }

    @Test
    public void TestGooglePixel(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test
    public void sampleTest() {

        driver.findElement(By.id("com.example:id/sampleElement")).click();
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

    }

    @AfterClass
    public void close(){
        driver.quit();
    }

}
