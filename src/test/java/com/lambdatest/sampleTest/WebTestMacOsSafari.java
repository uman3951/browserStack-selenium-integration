package com.lambdatest.sampleTest;

import com.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebTestMacOsSafari {
    RemoteWebDriver driver;
    @Test
    public void connectToLambdaTest() throws MalformedURLException {
        //ChromeOptions browserOptions = new ChromeOptions();
        SafariOptions browserOptions = new SafariOptions();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put(Constants.BUILD_NAME, "Test Lambda 3");
        ltOptions.put(Constants.PROJECT_NAME, "Test Lambda 3");
        ltOptions.put(Constants.BROWSER_NAME,"safari");
        ltOptions.put(Constants.BROWSER_VERSION,"15");
        ltOptions.put(Constants.PLATFORM_NAME,"macOS 12");
        browserOptions.setCapability("LT:Options", ltOptions);
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
