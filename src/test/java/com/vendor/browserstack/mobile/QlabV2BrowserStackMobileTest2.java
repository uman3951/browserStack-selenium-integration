package com.vendor.browserstack.mobile;

import com.common.Constants;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
//import com.syscolab.qe.core.util.browserstack.appdata;
import com.syscolab.qe.core.util.browserstack.appdata;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.HashMap;

public class QlabV2BrowserStackMobileTest2 {
    SyscoLabUI syscoLabUI;
    @Test
    public void testBrowserstackAndroid1() throws InterruptedException {
        String apkFilePath = Paths.get("src/test/resources/browserstackAppFiles/sample.apk").toString();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device:platform", "android");
        //Need to provide the location of the .apk file
        capabilities.setCapability("appium:app", appdata.uploadAppToBrowserStack(apkFilePath));
        capabilities.setCapability("appium:deviceName", "Google Pixel 6 Pro");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("buildName","Gevin2");
        browserstackOptions.put("projectName","Test Mobile");
        capabilities.setCapability("bstack:options", browserstackOptions);
        syscoLabUI = new SyscoLabWUI(capabilities,false);
        Thread.sleep(10000);
        Assert.assertEquals(syscoLabUI.getTitle(), "Swag Labs");
    }


    @AfterClass
    public void close(){
        syscoLabUI.quit();
    }

}
