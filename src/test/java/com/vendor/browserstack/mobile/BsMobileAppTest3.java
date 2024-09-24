/**
 * This is the latest implementation
 */
package com.vendor.browserstack.mobile;

import com.common.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BsMobileAppTest3 {
    AppiumDriver driver;
    @BeforeClass
    public void connectToBrowserStack() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"bs");
        capabilities.setCapability(Constants.PLATFORM_NAME, "android");
        capabilities.setCapability("app","bs://de65b35dec873f96532400d2a9ed2d14c745e430");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put(Constants.BUILD_NAME,"App Test 3");
        browserstackOptions.put(Constants.MOBILE_OS_VERSION, "12.0");
        browserstackOptions.put(Constants.MOBILE_DEVICE_NAME, "Google Pixel 6 Pro");
        capabilities.setCapability("bstack:options", browserstackOptions);
        driver = new AndroidDriver(new URL(Constants.HUB_URL), capabilities);
    }

    @Test
    public void TestGooglePixel(){
/*        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getTitle(), "Swag Labs");*/
    }

    @AfterClass
    public void close(){
        driver.quit();
    }

}
