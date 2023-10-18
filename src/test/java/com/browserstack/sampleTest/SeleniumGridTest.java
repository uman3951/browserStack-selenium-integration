//// NOTE: replace USERNAME:ACCESS_KEY@HUB_SUBDOMAIN and VIDEO_URL with your credentials found in the Gridlastic dashboard
//// ALSO SEE https://github.com/Gridlastic/demo1 FOR JAVA TESTNG EXAMPLES WITH PARALLEL TEST EXECUTIONS
//
//package com.browserstack.sampleTest;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import java.net.MalformedURLException;
//import java.net.URL;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//public class SeleniumGridTest {
//    WebDriver driver;
//    String baseUrl, nodeURL;
//    @BeforeSuite
//    public void setUpWthrows() throws MalformedURLException {
//        baseUrl = "http://newtours.demoaut.com/";
//        nodeURL = "http://192.168.1.6:4444/wd/hub";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities. setBrowserName("safari");
//       // capabilities. setPlatform(Platform.XP);
//        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
//    }
//    @AfterTest
//    public void afterTest() {
//        driver.quit();
//    }
//    @Test
//    public void simpleTest() {
//        driver.get(baseUrl);
//        Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle()); }
//}
