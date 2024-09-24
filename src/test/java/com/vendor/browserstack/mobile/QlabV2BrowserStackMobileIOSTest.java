//package com.vendor.browserstack.mobile;
//
//import com.common.Constants;
//import com.syscolab.qe.core.ui.SyscoLabUI;
//import com.syscolab.qe.core.ui.web.SyscoLabWUI;
////import com.syscolab.qe.core.util.browserstack.appdata;
//import com.syscolab.qe.core.util.browserstack.appdata;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.net.MalformedURLException;
//import java.nio.file.Paths;
//import java.util.HashMap;
//
//public class QlabV2BrowserStackMobileIOSTest {
//    SyscoLabUI syscoLabUI;
//    RemoteWebDriver driver;
//    String ipaFilePath = Paths.get("src/test/resources/browserstackAppFiles/proverbial_ios.ipa").toString();
//    @BeforeClass
//    public void connectToBrowserStack() throws MalformedURLException, InterruptedException {
////        DesiredCapabilities capabilities = new DesiredCapabilities();
////        //capabilities.setCapability(Constants.APPLICATION_NAME,"bs");
////        capabilities.setCapability(Constants.PLATFORM_NAME, "android");
////        capabilities.setCapability("appium:app","bs://125574196145a2c5623c31d1d82551874cf0f384");
////        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
////        browserstackOptions.put(Constants.BUILD_NAME,"App Test");
////        browserstackOptions.put(Constants.MOBILE_OS_VERSION, "12.0");
////        browserstackOptions.put(Constants.MOBILE_DEVICE_NAME, "Google Pixel 6 Pro");
////        capabilities.setCapability("bstack:options", browserstackOptions);
////        driver = new RemoteWebDriver(new URL(Constants.HUB_URL), capabilities);
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("device:platform", "ios");
//        capabilities.setCapability("appium:app", appdata.uploadAppToBrowserStack(ipaFilePath));
//       // capabilities.setCapability("appium:app", appdata.uploadAppToBrowserStack("/Users/udaramanupriya/Library/CloudStorage/OneDrive-SyscoCorporation/TP Team/ipaFiles/proverbial_ios.ipa"));
//
//        //capabilities.setCapability("appium:app", "bs://2f8d1f9189ac8ccf6460ce9e3fd0d763861922b9");
//        //Udara BS account
//        //capabilities.setCapability("appium:app", "bs://125574196145a2c5623c31d1d82551874cf0f384");
//        capabilities.setCapability("appium:deviceName", "iPhone XR");
//        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//        browserstackOptions.put(Constants.BUILD_NAME,"Test IOS Mobile 6_8");
//        capabilities.setCapability("bstack:options", browserstackOptions);
//        syscoLabUI = new SyscoLabWUI(capabilities,false);
//    }
//    @Test
//    public void sampleTest() {
//
//        //syscoLabUI.findElement(By.id("com.example:id/sampleElement")).click();
//        Assert.assertTrue(true);
//
////        driver.findElement(By.id("com.example:id/sampleElement")).click();
////        Assert.assertEquals(driver.getTitle(), "Swag Labs");
//
//    }
//
//    @AfterClass
//    public void close(){
//        syscoLabUI.quit();
////        driver.quit();
//    }
//
//}
