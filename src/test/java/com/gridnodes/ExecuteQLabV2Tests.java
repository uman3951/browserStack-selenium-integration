package com.gridnodes;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;

import com.syscolab.qe.core.util.browserstack.MobileAppUpload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class ExecuteQLabV2Tests {

    public static final String FILE_UPLOAD_URL="https://the-internet.herokuapp.com/upload";
    By fileInput = By.id("file-upload");

    SyscoLabUI syscoLabUI;
    ChromeOptions chromeOptions;

    /*public void connectToBrowserStack() throws MalformedURLException, InterruptedException {
       /* DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device:platform", "android");
        //Old apk
        //capabilities.setCapability("appium:app", "bs://8407e5ee4bd61f88b2f8bad0962e15d2444b2e6b");
        //New APK
        capabilities.setCapability("appium:app", "bs://125574196145a2c5623c31d1d82551874cf0f384");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put(Constants.BUILD_NAME,"Test Mobile 1");
        //browserstackOptions.put(Constants.MOBILE_OS_VERSION, "13.0");
        browserstackOptions.put("appium:deviceName", "Samsung Galaxy S24 Ultra");
        browserstackOptions.put("local", "false");
        capabilities.setCapability("bstack:options", browserstackOptions);
        syscoLabUI = new SyscoLabWUI(capabilities,false);
        //driver = new RemoteWebDriver(new URL(Constants.HUB_URL), capabilities);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(Constants.APPLICATION_NAME,"bs");
        //capabilities.setCapability("device:platform", "android");
        //New APK
        //capabilities.setCapability("appium:app", appdata.uploadAppToBrowserStack("/Users/udaramanupriya/Library/CloudStorage/OneDrive-SyscoCorporation/TP Team/apkFiles/sample.apk"));
       // capabilities.setCapability("appium:app", "bs://2f8d1f9189ac8ccf6460ce9e3fd0d763861922b9");
       // capabilities.setCapability("appium:deviceName", "Samsung Galaxy S24 Ultra");
        //HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        //browserstackOptions.put(Constants.BUILD_NAME,"Test Web 1");
        // browserstackOptions.put(BrowserStackConstants.PROJECT_NAME,"Test Mobile");
        //browserstackOptions.put(Constants.MOBILE_OS_VERSION, "13.0");
        //capabilities.setCapability("bstack:options", browserstackOptions);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        syscoLabUI = new SyscoLabWUI(capabilities,false);
    }
    */


//    @Test
//    public void TestGooglePixel(){
//        syscoLabUI.navigateTo("https://www.saucedemo.com");
//        syscoLabUI.findElement(By.id("user-name")).sendKeys("standard_user");
//        syscoLabUI.findElement(By.id("password")).sendKeys("secret_sauce");
//        syscoLabUI.findElement(By.id("login-button")).click();
//        Assert.assertEquals(syscoLabUI.getTitle(), "Swag Labs");
//    }


    @Test
    public void testQLabV2fileUpload() throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        //file path in the project structure
        String filePath = "src/test/resources/qlabV2FileUpload/test.csv";
        syscoLabUI = new SyscoLabWUI(desiredCapabilities,false);
        syscoLabUI.navigateTo(FILE_UPLOAD_URL);
        syscoLabUI.qLabV2FileUpload(filePath,fileInput);
        syscoLabUI.findElement(By.id("file-submit")).click();
        WebElement fileName = syscoLabUI.findElement(By.id("uploaded-files"));
        //Assert the file upload is successful
        Assert.assertEquals("test.csv", fileName.getText());
        Thread.sleep(20000);
    }

//    @Test
//    public void downloads() throws IOException, InterruptedException {
//        ChromeOptions   chromeOptions = new ChromeOptions();
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setBrowserName("chrome");
//        chromeOptions.setEnableDownloads(true);
//        desiredCapabilities.merge(chromeOptions);
//        // desiredCapabilities.setCapability("se:downloadsEnabled",true);
//        syscoLabUI = new SyscoLabWUI(desiredCapabilities, false);
//        //syscoLabUI = new SyscoLabWUI(SyscoLabBrowserTypes.CHROME, chromeOptions);
//
//        List<String> fileNames = new ArrayList<>();
//        syscoLabUI.navigateTo("https://www.selenium.dev/selenium/web/downloads/download.html");
//        syscoLabUI.findElement(By.id("file-1")).click();
//        Thread.sleep(10000);
//
//
//        Path targetDirectory = Paths.get(System.getProperty("user.dir") + "/src/test/resources/fileDownLoad");
//
//        ((HasDownloads) syscoLabUI.getDriver()).downloadFile("file_1.txt", targetDirectory);
//        Thread.sleep(10000);
//        Assert.assertTrue(Files.exists(targetDirectory));
//    }x

    @Test(description = "SyscoLabUITests:00106- Validate testQLabV2fileDownload")
    public void downloadsChrome() throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        syscoLabUI = new SyscoLabWUI(desiredCapabilities, false);
        syscoLabUI.navigateTo("https://www.selenium.dev/selenium/web/downloads/download.html");
        Thread.sleep(5000);
        String target = "/src/test/resources/qlabV2FileDownLoad";
        By fileDownload = By.id("file-1");
        syscoLabUI.qLabV2FileDownload(target, fileDownload );
        Thread.sleep(5000);
        Path targetDirectory = Paths.get(System.getProperty("user.dir") + "/src/test/resources/qlabV2FileDownLoad");
        Assert.assertTrue(Files.exists(targetDirectory));
    }

    @Test(description = "SyscoLabUITests:00106- Validate testQLabV2fileDownload")
    public void downloadsEdge() throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("MicrosoftEdge");
        syscoLabUI = new SyscoLabWUI(desiredCapabilities, false);
        syscoLabUI.navigateTo("https://www.selenium.dev/selenium/web/downloads/download.html");
        Thread.sleep(5000);
        String target = "/src/test/resources/qlabV2FileDownLoad";
        By fileDownload = By.id("file-1");
        syscoLabUI.qLabV2FileDownload(target, fileDownload );
        Thread.sleep(5000);
        Path targetDirectory = Paths.get(System.getProperty("user.dir") + "/src/test/resources/qlabV2FileDownLoad");
        Assert.assertTrue(Files.exists(targetDirectory));
    }

    @Test
    public void testBrowserstackAndroid() {
        String apkFilePath = Paths.get("src/test/resources/browserstackAppFiles/sample.apk").toString();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device:platform", "android");
        //Need to provide the location of the .apk file
        capabilities.setCapability("appium:app", MobileAppUpload.uploadAppToBrowserStack(apkFilePath));
        capabilities.setCapability("appium:deviceName", "Google Pixel 6 Pro");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("buildName","Test Mobile 20_8");
        browserstackOptions.put("projectName","Test Mobile");
        capabilities.setCapability("bstack:options", browserstackOptions);
        syscoLabUI = new SyscoLabWUI(capabilities,false);
        syscoLabUI.findElement(By.id("com.example:id/sampleElement")).click();
        Assert.assertEquals(syscoLabUI.getTitle(), "Swag Labs");
    }

    @AfterClass
    public void close(){
        syscoLabUI.quit();
    }

}
