package com.sourcelabs.sampleTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobileTest {
    @Test
    public void connectToSourceLabs() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();// specific deviceId
        HashMap<String, Object> sauceOptions = new HashMap<String, Object>();
        sauceOptions.put("username", "umanupriya");
        sauceOptions.put("accessKey", "365683d7-c41b-4750-b14e-64477c84fc39");
        sauceOptions.put("platformName","ANDROID");
        sauceOptions.put("appium:deviceName", "Google Pixel 6 Pro GoogleAPI Emulator");
        sauceOptions.put("realMobile", "true");
        sauceOptions.put("appium:app","storage:c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        capabilities.setCapability("sauce:options", sauceOptions);
        RemoteWebDriver androidDriver = new AndroidDriver(new URL("http://192.168.1.13:4444"), capabilities);
        WebElement searchElement = new WebDriverWait(androidDriver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Search Wikipedia")));
        searchElement.click();
        WebElement insertTextElement =  new WebDriverWait(androidDriver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);

        List<WebElement> allProductsName = androidDriver.findElements(By.className("android.widget.TextView"));
        Assert.assertTrue(allProductsName.size() > 0);
        androidDriver.quit();
    }
}
