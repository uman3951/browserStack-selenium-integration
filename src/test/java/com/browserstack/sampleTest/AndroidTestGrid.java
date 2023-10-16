package com.browserstack.sampleTest;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class AndroidTestGrid extends BrowserStackTestBase {
    WebDriver driver;
    String baseUrl, nodeURL;
    @BeforeSuite
    public void setUpWthrows() throws MalformedURLException {
        nodeURL = "http://192.168.1.100:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        // capabilities. setPlatform(Platform.XP);
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
    }
    @BeforeClass
    public void setUp() throws Exception {
        capabilitySetUp("sample.conf.json","BrowserStack.mobile","env1",null, null);
    }

    @Test
    public void andriodTest() throws Exception {
      WebElement searchElement = new WebDriverWait(androidDriver, Duration.ofSeconds(30)).until(
          ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
      searchElement.click();
      WebElement insertTextElement =  new WebDriverWait(androidDriver, Duration.ofSeconds(30)).until(
          ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
      insertTextElement.sendKeys("BrowserStack");
      Thread.sleep(5000);

      List<WebElement> allProductsName = androidDriver.findElements(By.className("android.widget.TextView"));
      Assert.assertTrue(allProductsName.size() > 0);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDownWebDriver() {
        androidDriver.quit();
    }
}
