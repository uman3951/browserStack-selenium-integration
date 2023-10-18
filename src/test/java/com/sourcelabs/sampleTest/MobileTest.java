package com.sourcelabs.sampleTest;

import com.common.Constants;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileTest {
    @Test
    public void connectToSourceLabs() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put(Constants.SOURCE_LABS_USER_NAME, "umanupriya");
        sauceOptions.put(Constants.SOURCE_LABS_ACCESS_KEY, "365683d7-c41b-4750-b14e-64477c84fc39");
        sauceOptions.put(Constants.BUILD_NAME, "Test Android");
        sauceOptions.put(Constants.TEST_NAME, "Testing Integration");
        sauceOptions.put(Constants.MOBILE_OS_VERSION, "12.0");
        sauceOptions.put(Constants.MOBILE_DEVICE_NAME, "Google Pixel 6 Pro GoogleAPI Emulator");
        sauceOptions.put("local", "false");
        capabilities.setCapability("sauce:options", sauceOptions);

        AppiumDriver driver = new AndroidDriver(new URL("http://10.140.38.206:4444"), capabilities);

        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");

        driver.quit();
    }
}
