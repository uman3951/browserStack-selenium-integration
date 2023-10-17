package com.sourcelabs.sampleTest;


import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SampleTest {
    WebDriver driver;

    @Test
    public void connectToSourceLabs() throws MalformedURLException {
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setPlatformName("macOS 12");
        browserOptions.setBrowserVersion("15");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "Test");
        sauceOptions.put("name", "Test");
        sauceOptions.put("username","umanupriya");
        sauceOptions.put("accessKey", "P5ZhVzDqefc6KgEWLymW");
        browserOptions.setCapability("sauce:options", sauceOptions);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), browserOptions);
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.quit();
    }
}
