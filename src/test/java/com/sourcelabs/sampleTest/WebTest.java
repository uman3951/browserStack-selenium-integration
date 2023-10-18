package com.sourcelabs.sampleTest;

import com.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WebTest {
    @Test
    public void connectToSourceLabs() throws MalformedURLException {
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setPlatformName("macOS 12");
        browserOptions.setBrowserVersion("15");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put(Constants.BUILD_NAME, "Test1");
        sauceOptions.put(Constants.TEST_NAME, "Test1");
        sauceOptions.put(Constants.SOURCE_LABS_USER_NAME, "umanupriya");
        sauceOptions.put(Constants.SOURCE_LABS_ACCESS_KEY, "365683d7-c41b-4750-b14e-64477c84fc39");
        browserOptions.setCapability("sauce:options", sauceOptions);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.140.38.206:4444"), browserOptions);

        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
        driver.quit();
    }
}
