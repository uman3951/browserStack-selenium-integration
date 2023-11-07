package com.sourcelabs.sampleTest;

import com.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
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

public class WebTest4 {
    RemoteWebDriver driver;
    @BeforeClass
    public void connectToSourceLabs() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("networkname:applicationName","sourceLabs");

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put(Constants.BUILD_NAME, "Test-SourceLabs");
        sauceOptions.put(Constants.TEST_NAME, "Test-SourceLabs");
        sauceOptions.put(Constants.SOURCE_LABS_USER_NAME, "oauth-udara.manupriya-054b4");
        sauceOptions.put(Constants.SOURCE_LABS_ACCESS_KEY, "2fba17e7-bfbd-4027-8c21-bef0f924dda0");
        sauceOptions.put(Constants.BROWSER_NAME,"chrome");
        sauceOptions.put(Constants.BROWSER_VERSION,"116");
        sauceOptions.put(Constants.PLATFORM_NAME,"Windows 11");
        capabilities.setCapability("sauce:options", sauceOptions);
        driver = new RemoteWebDriver(new URL("http://192.168.8.137:4444"), capabilities);
    }
    @Test
    public void testSourceDemoViaSourceLabs(){
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
