package com.sourcelabs.sampleTest;

import com.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WebTest {
    RemoteWebDriver driver;
    @BeforeClass
    public void connectToSourceLabs() throws MalformedURLException {
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setPlatformName("macOS 12");
        browserOptions.setBrowserVersion("15");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put(Constants.BUILD_NAME, "Test-Web");
        sauceOptions.put(Constants.TEST_NAME, "Test-Web");
        sauceOptions.put(Constants.SOURCE_LABS_USER_NAME, "oauth-kherath17-74da0");
        sauceOptions.put(Constants.SOURCE_LABS_ACCESS_KEY, "06a67e1c-ec8e-4f05-a6c8-5c6e816b079d");
        browserOptions.setCapability("sauce:options", sauceOptions);
        driver = new RemoteWebDriver(new URL("http://192.168.1.4:4444"), browserOptions);
    }
    @Test
    public void testSourceDemo(){
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
