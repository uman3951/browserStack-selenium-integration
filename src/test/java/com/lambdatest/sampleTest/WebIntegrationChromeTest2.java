package com.lambdatest.sampleTest;

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

public class WebIntegrationChromeTest2 {
    RemoteWebDriver driver;
    @BeforeClass
    public void connectToLambdaTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"lambda");
        capabilities.setCapability(Constants.BROWSER_NAME,"chrome");
        capabilities.setCapability(Constants.PLATFORM_NAME,"Windows 11");
        capabilities.setCapability(Constants.BROWSER_VERSION,"116");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put(Constants.BUILD, "Test Lambda Integration 2");
        ltOptions.put(Constants.PROJECT_NAME, "Test Lambda Integration 2");

        capabilities.setCapability("LT:Options", ltOptions);
        driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444"), capabilities);
    }
    @Test
    public void testSourceDemoViaLambda(){
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
