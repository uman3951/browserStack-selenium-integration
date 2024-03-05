package com.gridnodes;

import com.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

class WebIntegrationChromeTest {
    RemoteWebDriver driver;
    @BeforeClass
    public void connectToLocal() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(Constants.APPLICATION_NAME,"local");
        capabilities.setCapability(Constants.BROWSER_NAME,"chrome");
        capabilities.setCapability(Constants.PLATFORM_NAME,"Windows 10");
        //capabilities.setCapability(Constants.BROWSER_VERSION,"116");
        Map<String, Object> bsOptions = new HashMap<>();
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:55535"), capabilities);
    }
    @Test
    public void testDemoViaLocal(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
        driver.quit();
    }
    @Test
    public void fileUpload(){
        String baseUrl = "https://demo.guru99.com/test/upload/";
        driver.manage().window().maximize();
        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\newhtml.html");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
