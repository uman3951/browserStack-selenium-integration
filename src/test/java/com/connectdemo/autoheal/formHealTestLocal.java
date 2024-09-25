package com.connectdemo.autoheal;

import com.syscolab.qe.core.common.LoggerUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * @author Kasun Herath
 */
public class formHealTestLocal {
    //RemoteWebDriver syscoLabUI;
    SyscoLabUI syscoLabUI;
    DesiredCapabilities desiredCapabilities;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");

    }


    /**
     * This is the after deployment (after firstName locator get changed)
     * @throws InterruptedException
     */
    @Test
    public void testAutoHealEnabled() throws InterruptedException {

        syscoLabUI = new SyscoLabWUI(desiredCapabilities, false);
        //No Changes in the UI - Initial Mandatory Run
        syscoLabUI.navigateTo("https://perfplatform.cloud.sysco.net/files/jenkins/PerfPlatformTest-Develop/55/distributed-jmeter-slave-qperfdevelop-55-server-79bf4574c7kfc4n/checkout/");
        //Changes in the UI - Healing Run
        //syscoLabUI.navigateTo("https://perfplatform.cloud.sysco.net/files/jenkins/PerfPlatformTest-Develop/74/distributed-jmeter-slave-qperfdevelop-74-server-78b694b464cgxf9/checkout/");
        Thread.sleep(10000);
        syscoLabUI.findElement(By.id("firstName")).sendKeys("Udara");
        syscoLabUI.findElement(By.id("lastName")).sendKeys("Manupriya");
        syscoLabUI.findElement(By.id("username")).sendKeys("uman3951");
        syscoLabUI.findElement(By.id("email")).sendKeys("uman@nomail.com");
        syscoLabUI.findElement(By.xpath("//input[@id='address1']")).sendKeys("Gampaha");
        syscoLabUI.findElement(By.id("address2")).sendKeys("Minuwangoda");
        new Select(syscoLabUI.findElement(By.id("country"))).selectByVisibleText("Sri Lanka");
        new Select(syscoLabUI.findElement(By.id("state"))).selectByVisibleText("Central");
        syscoLabUI.findElement(By.id("zip")).sendKeys("90000CF");
        syscoLabUI.clickWithJavascript(By.id("debit"));
        syscoLabUI.findElement(By.id("cc-name")).sendKeys("umanupriya");
        syscoLabUI.findElement(By.id("cc-number")).sendKeys("1234567890123456");
        syscoLabUI.findElement(By.id("cc-expiration")).sendKeys("12/30");
        syscoLabUI.findElement(By.id("cc-cvv")).sendKeys("123");
        syscoLabUI.scrollUp();
        syscoLabUI.scrollBottom();
        syscoLabUI.findElement(By.xpath("//button[text()='Checkout']"));
        LoggerUtil.logINFO("----------: Check out from the Form");
      //  assertTrue(syscoLabUI.getCurrentURL().contains("paymentMethod=on"));
    }

    @AfterMethod
    public void tearDown() {
        syscoLabUI.quit();
    }
}