package com.vendor.localGrid;

import com.common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.HasDownloads;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;

public class SampleTest {
    RemoteWebDriver driver;
    DesiredCapabilities capabilities;
    ChromeOptions options;
    @BeforeClass
    public void connectToHub() throws MalformedURLException {
        //capabilities = new DesiredCapabilities();
        options = new ChromeOptions();
        options.setEnableDownloads(true);
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        //capabilities.setBrowserName("chrome");
        //capabilities.setPlatform(Platform.LINUX);
       // capabilities.setCapability("se:name","myTest");
     //   Map<String, Object> prefs = new HashMap<>();
      //  prefs.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources");
      //  options.setExperimentalOption("prefs", prefs);
        driver = new RemoteWebDriver(new URL(Constants.HUB_URL), options);
    }
    @Test
    public void testDemo() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        String sessionId =  driver.getSessionId().toString();
        System.out.println("=======================");
        System.out.println("Session Id = "+sessionId);
        Thread.sleep(100000);
        Assert.assertEquals(driver.getTitle(),"Privacy error");
    }

    @Test
    public void downloads() throws IOException, InterruptedException {

        //List<String> fileNames = new ArrayList<>();
        //fileNames.add("file_1.txt");
        driver.get("https://www.selenium.dev/selenium/web/downloads/download.html");
        driver.findElement(By.id("file-1")).click();
        Thread.sleep(5000);

        List<String> files = ((HasDownloads) driver).getDownloadableFiles();

        String downloadableFile = files.get(0);
        Path targetDirectory = Paths.get(System.getProperty("user.dir") + "/src/test/resources/fileDownLoad");


        ((HasDownloads) driver).downloadFile("file_1.txt", targetDirectory);
        Assert.assertTrue(Files.exists(targetDirectory));
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
