package com.browserstack.sampleTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;

public class AndroidTest extends BrowserStackTestBase {
    @BeforeSuite
    public void setUp() throws Exception {
        mobileCapabilitySetUp("mobileSample.conf.json","mobile");
    }

    @Test
    public void andriodTest() throws Exception {
      AndroidElement searchElement = (AndroidElement) new WebDriverWait(androidDriver, 30).until(
          ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
      searchElement.click();
      AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(androidDriver, 30).until(
          ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
      insertTextElement.sendKeys("BrowserStack");
      Thread.sleep(5000);

      List<AndroidElement> allProductsName = androidDriver.findElementsByClassName("android.widget.TextView");
      Assert.assertTrue(allProductsName.size() > 0);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDownWebDriver() {
        androidDriver.quit();
    }
}
