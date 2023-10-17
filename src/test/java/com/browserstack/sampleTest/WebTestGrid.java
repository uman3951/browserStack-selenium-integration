package com.browserstack.sampleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WebTestGrid {
    @Test
    public void connectToBrowserStack() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("WINDOWS 11");
        browserOptions.setBrowserVersion("104");
        Map<String, Object> bsOptions = new HashMap<>();
        bsOptions.put("buildName", "Test");
        browserOptions.setCapability("bstack:options", bsOptions);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.100:4444"), browserOptions);
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
        driver.quit();
    }
}
