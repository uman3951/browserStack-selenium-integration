package com.browserstack.sampleTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestChrome {
    WebDriver driver;
    String baseUrl, nodeURL;

@Test
   public void testwebDriver() throws MalformedURLException, InterruptedException {

        baseUrl = "http://www.google.com";
        nodeURL = "http://192.168.1.100:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        // capabilities. setPlatform(Platform.XP);
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
        driver.get(baseUrl);
        driver.wait(1000);

        }


        @AfterMethod(alwaysRun = true)
    public void tearDownWebDriver() {
            driver.quit();
    }

   }

