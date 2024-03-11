package com.vendor.localGrid;

import com.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
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

public class SampleTest {
    RemoteWebDriver driver;
    @BeforeClass
    public void connectToHub() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
        capabilities.setCapability("se:name","myTest");
        driver = new RemoteWebDriver(new URL(Constants.HUB_URL), capabilities);
    }
    @Test
    public void testDemo() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        String sessionId =  driver.getSessionId().toString();
        System.out.println("=======================");
        System.out.println("Session Id = "+sessionId);
        Thread.sleep(100000);
        Assert.assertEquals(driver.getTitle(),"Privacy error");
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
