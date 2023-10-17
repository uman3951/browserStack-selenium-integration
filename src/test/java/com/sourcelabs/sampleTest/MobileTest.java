package com.sourcelabs.sampleTest;

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
        sauceOptions.put("username", "umanupriya");
        sauceOptions.put("accessKey", "365683d7-c41b-4750-b14e-64477c84fc39");
        sauceOptions.put("build", "Test Android");
        sauceOptions.put("name", "Testing Integration");

        capabilities.setCapability("appium:deviceName", "Google Pixel 6 Pro GoogleAPI Emulator");
        capabilities.setCapability("appium:platformVersion", "12.0");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platformName", "ANDROID");

        capabilities.setCapability("sauce:options", sauceOptions);


        AppiumDriver driver = new AndroidDriver(new URL("http://192.168.1.100:4444"), capabilities);

        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");

        driver.quit();
    }
}
