package com.vendor.browserstack.mobile;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import com.syscolab.qe.core.util.browserstack.MobileAppUpload;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.HashMap;

public class QlabV2BrowserStackMobileTest3 {
    SyscoLabUI syscoLabUI;
    @Test
    public void testBrowserstackAndroid3() throws InterruptedException {
        String apkFilePath = Paths.get("src/test/resources/browserstackAppFiles/sample.apk").toString();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device:platform", "android");
        //Need to provide the location of the .apk file
        capabilities.setCapability("appium:app", MobileAppUpload.uploadAppToBrowserStack(apkFilePath));
        capabilities.setCapability("appium:deviceName", "Google Pixel 6 Pro");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("buildName","Test Mobile Gevin3");
        browserstackOptions.put("projectName","Test Mobile");
        capabilities.setCapability("bstack:options", browserstackOptions);
        syscoLabUI = new SyscoLabWUI(capabilities,false);
        Thread.sleep(10000);
        syscoLabUI.findElement(By.id("com.example:id/sampleElement")).click();
        Assert.assertEquals(syscoLabUI.getTitle(), "Swag Labs");
    }


    @AfterClass
    public void close(){
        syscoLabUI.quit();
    }

}
