package com.browserstack.sampleTest;

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

public class BsWebIntegrationMacTest1 {
    RemoteWebDriver driver;
    @BeforeClass
    public void connectToBrowserStack() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"bs");
        capabilities.setCapability(Constants.BROWSER_NAME,"safari");
        capabilities.setCapability(Constants.PLATFORM_NAME,"mac");
        capabilities.setCapability(Constants.BROWSER_VERSION,"15");
        Map<String, Object> bsOptions = new HashMap<>();
        bsOptions.put(Constants.PROJECT_NAME, "Test BS");
        bsOptions.put(Constants.BUILD_NAME, "Test BS Integration Mac ");

        capabilities.setCapability("bstack:options", bsOptions);
        driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444"), capabilities);

    }
    @Test
    public void testDemoViaBS(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
        driver.quit();
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
