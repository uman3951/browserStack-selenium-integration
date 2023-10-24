package com.lambdatest.sampleTest;

import com.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WebTest {
    RemoteWebDriver driver;
    @Test
    public void connectToLambdaTest() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
       // browserOptions.setPlatformName("Windows 11");
       // browserOptions.setBrowserVersion("104.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put(Constants.BUILD_NAME, "Test Lambda");
        ltOptions.put(Constants.PROJECT_NAME, "Test Lambda");
        ltOptions.put(Constants.BROWSER_NAME,"chrome");
        ltOptions.put(Constants.BROWSER_VERSION,"104");
        ltOptions.put(Constants.PLATFORM_NAME,"Windows 11");
        browserOptions.setCapability("LT:Options", ltOptions);
       //driver = new RemoteWebDriver(new URL("https://udara.manupriya:Ejvwi0FShhVeYpQW2fUwemw88y2DzBbiwFCWdQqYXck9T8WUcM@hub.lambdatest.com/wd/hub"), browserOptions);
        driver = new RemoteWebDriver(new URL("http://192.168.1.9:4444"), browserOptions);
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
