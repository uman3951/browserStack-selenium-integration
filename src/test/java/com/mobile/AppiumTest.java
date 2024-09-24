package com.mobile;

import com.common.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class AppiumTest {
    @Test
    public static void sampleTest() {
        try {
            // Set Desired Capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "ANDROID");
            //caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A 13");  // Your device name
           // caps.setCapability(MobileCapabilityType.UDID, "R58T61L85ZZ");  // Your device's UDID
            caps.setCapability("browserName", "Chrome");  // Set browser to Chrome
            caps.setCapability("appium:platformVersion", "11");


            // Appium Server URL (from Kubernetes ingress)
          //  URL url = new URL("http://localhost:4444");

            // Initialize AndroidDriver for Chrome
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps);

            // Open Chrome and navigate to Google
            driver.get("https://www.google.com");

            // Perform the search for "Sysco Labs"
            driver.findElement(By.name("q")).sendKeys("Sysco Labs");
            driver.findElement(By.name("q")).submit();

            // Wait for results to load (optional, can be improved with WebDriverWait)
            Thread.sleep(3000);

            // Sample: Print the page title
            System.out.println("Page title is: " + driver.getTitle());

            // Quit the driver
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
