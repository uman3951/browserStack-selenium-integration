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

public class BsMobileAppIOSTestNew {
    RemoteWebDriver driver;
    @BeforeClass
    public void connectToBrowserStack() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"bs");
        capabilities.setCapability("device:platform", "ios");
        capabilities.setCapability("appium:deviceName", "iPhone 14");

        capabilities.setCapability("appium:app", "bs://65fbdb23191ac41e868a60af2e918415b808d4fb");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put(Constants.BUILD_NAME,"Test Mobile IOS 17_7");
        browserstackOptions.put(Constants.PROJECT_NAME,"test");
       // browserstackOptions.put(Constants.MOBILE_OS_VERSION, "13.0");
       // browserstackOptions.put("appium:deviceName", "Google Pixel 6 Pro");
      //  browserstackOptions.put("local", "false");
        capabilities.setCapability("bstack:options", browserstackOptions);
        driver = new RemoteWebDriver(new URL(Constants.HUB_URL), capabilities);
    }

    @Test
    public void sampleTest() {

        //driver.findElement(By.id("com.example:id/sampleElement")).click();
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

    }

    @AfterClass
    public void close(){
        driver.quit();
    }

}
