package com.connectdemo.autoheal;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
//import com.syscolab.qe.core.util.browserstack.appdata;
import com.syscolab.qe.core.util.browserstack.MobileAppUpload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.HashMap;

public class QlabV2BrowserStackMobileTest {
    SyscoLabUI syscoLabUI;
    RemoteWebDriver driver;
    @Test
    public void testBrowserstackAndroid() throws InterruptedException {
        String apkFilePath = Paths.get("src/test/resources/browserstackAppFiles/sample.apk").toString();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device:platform", "android");
        //Need to provide the location of the .apk file
        capabilities.setCapability("appium:app", MobileAppUpload.uploadAppToBrowserStack(apkFilePath));
        capabilities.setCapability("appium:deviceName", "Google Pixel 6 Pro");
        capabilities.setCapability("networkname:applicationName","bs");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("buildName","Test Mobile Gevin");
        browserstackOptions.put("projectName","Test Mobile");
        capabilities.setCapability("bstack:options", browserstackOptions);
        syscoLabUI = new SyscoLabWUI(capabilities,false);
        Thread.sleep(1000);
        //syscoLabUI.findElement(By.id("com.example:id/sampleElement")).click();
        Assert.assertEquals(syscoLabUI.getTitle(), "Swag Labs");
    }

    @Test
    public void testBrowserstackIOS() {
        String ipaFilePath = Paths.get("src/test/resources/browserstackAppFiles/proverbial_ios.ipa").toString();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device:platform", "ios");
        //Need to provide the location of the .ipa file
        capabilities.setCapability("appium:app", MobileAppUpload.uploadAppToBrowserStack(ipaFilePath));
        capabilities.setCapability("appium:deviceName", "iPhone XR");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("buildName","Test IOS Mobile 3");
        capabilities.setCapability("bstack:options", browserstackOptions);
        syscoLabUI = new SyscoLabWUI(capabilities,false);
//        WebElement btnAlert = syscoLabUI.findVisibleElement(By.name("Allow"));
//        WebElement btnText = syscoLabUI.findVisibleElement(By.name("Text"));
//        btnAlert.click();
//        Assert.assertTrue(btnText.isDisplayed());
    }


    @AfterClass
    public void close(){
        syscoLabUI.quit();
//        driver.quit();
    }

}
