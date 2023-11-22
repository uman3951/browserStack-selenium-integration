package com.vendor.sourcelabs.web;

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
import java.util.Map;

public class SourceLabsWebIntegrationChromeTest3 {
    RemoteWebDriver driver;
    @BeforeClass
    public void connectToSourceLabs() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"sourceLabs");
        capabilities.setCapability(Constants.BROWSER_NAME,"chrome");
        capabilities.setCapability(Constants.PLATFORM_NAME,"Windows 11");
        capabilities.setCapability(Constants.BROWSER_VERSION,"116");

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put(Constants.BUILD, "Test Source Integration 3");
        sauceOptions.put(Constants.TEST_NAME, "Test Source Integration 3");
        capabilities.setCapability("sauce:options", sauceOptions);
        driver = new RemoteWebDriver(new URL(Constants.HUB_URL), capabilities);
    }
    @Test
    public void testDemoViaSourceLabs(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
