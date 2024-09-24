package com.mobile;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumGridTest {

    private RemoteWebDriver driver;
    private DesiredCapabilities capabilities;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "11");
        capabilities.setCapability("appium:udid", "R58T61L85ZZ");
        capabilities.setCapability("appium:deviceName", "samsung A 13");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:wdaLocalPort", 8100);
        capabilities.setCapability("appium:mjpegServerPort", 9100);
        capabilities.setCapability("appium:app", "/Users/udaramanupriya/Library/CloudStorage/OneDrive-SyscoCorporation/Documents/Codes/SUTAP_Ext/browserStack-selenium-integration/src/test/resources/browserstackAppFiles/sample.apk");  // Timeout in milliseconds (60 seconds)

        driver = new RemoteWebDriver(new URL("https://perfplatform.cloud.sysco.net/appium"), capabilities);
    }

    @Test(priority = 0)
    public void runTheApp() {
        System.out.println("Running the App on Android!");
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
} 