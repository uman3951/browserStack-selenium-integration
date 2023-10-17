package com.browserstack.sampleTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidTestGrid {
    @Test
    public void connectToBrowserStack() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("platformName", "Android");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("deviceName", "Google Pixel 6 Pro GoogleAPI Emulator");
        sauceOptions.put("platformName","Android");
        sauceOptions.put("build", "1234");
        sauceOptions.put("name", "Testing Integration");
        sauceOptions.put("username", "udaramanupriya_SWZuOh");
        sauceOptions.put("accessKey", "06a67e1c-ec8e-4f05-a6c8-5c6e816b079d");
        capabilities.setCapability("sauce:options", sauceOptions);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), capabilities);
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
    }
}
