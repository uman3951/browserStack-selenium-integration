package com.browserstack.sampleTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class MobileTestGrid {
    @Test
    public void connectToBrowserStack() throws MalformedURLException, InterruptedException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("deviceName", "Google Pixel 6 Pro");
        capabilities.setCapability("realMobile", "true");
        capabilities.setCapability("app","bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        capabilities.setCapability("browserstack.user", "udaramanupriya_SWZuOh");
        capabilities.setCapability("browserstack.key", "P5ZhVzDqefc6KgEWLymW");
        RemoteWebDriver androidDriver = new AndroidDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities);
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
