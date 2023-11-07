package com.browserstack.sampleTest;

import com.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WebTest1 {
    RemoteWebDriver driver;
    @BeforeClass
    public void connectToBrowserStack() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("WINDOWS 11");
        browserOptions.setBrowserVersion("104");
        Map<String, Object> bsOptions = new HashMap<>();
        bsOptions.put(Constants.WEB_BUILD_NAME, "Test");
        browserOptions.setCapability("bstack:options", bsOptions);
        driver = new RemoteWebDriver(new URL("http://192.168.1.9:4444"), browserOptions);
    }
    @Test
    public void testSourceDemo(){
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
