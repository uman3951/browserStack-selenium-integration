package com.browserstack.sampleTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.SSLContext;
import java.net.MalformedURLException;
import java.net.URL;

public class WebTestGrid extends BrowserStackTestBase {
    WebDriver driver;
    String baseUrl, nodeURL;
    @BeforeSuite
    public void setUpWthrows() throws MalformedURLException {
        nodeURL = "http://192.168.1.13:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        // capabilities. setPlatform(Platform.XP);
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);

    }
    @BeforeClass
    public void setUp() throws Exception {
        capabilitySetUp("sample.conf.json","BrowserStack.web","env1",null,null);
    }

    @Test
    public void test() throws Exception {
    	// navigate to bstackdemo
        webDriver.get("https://www.bstackdemo.com");

        // Check the title
        Assert.assertTrue(webDriver.getTitle().matches("StackDemo"));
        
        // Save the text of the product for later verify
        String productOnScreenText = webDriver.findElement(By.xpath("//*[@id=\"1\"]/p")).getText();
        // Click on add to cart button
        webDriver.findElement(By.xpath("//*[@id=\"1\"]/div[4]")).click();
        
        // See if the cart is opened or not
        Assert.assertTrue(webDriver.findElement(By.cssSelector(".float\\-cart__content")).isDisplayed());
        
        // Check the product inside the cart is same as of the main page
        String productOnCartText = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]")).getText();
        Assert.assertEquals(productOnScreenText, productOnCartText);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDownWebDriver() {
        webDriver.quit();
    }
}
