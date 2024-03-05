package com.fileupload;

import com.common.Constants;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
public class FileUpload {

    @Test
    public void fileUpload() throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setCapability("platformName", Platform.LINUX);
        SyscoLabUI syscoLabUI = new SyscoLabWUI(desiredCapabilities, false);
        syscoLabUI.getDriver().setFileDetector(new LocalFileDetector());
        String filePath = "src/test/resources/selenium-snapshot.png";
        //String filePath = "src/test/resources/test.csv";
        File file = new File(filePath);
        syscoLabUI.navigateTo("https://demo.automationtesting.in/FileUpload.html");
        WebElement uploadElement = syscoLabUI.findElement(By.id("input-4"));
        uploadElement.sendKeys(file.getAbsolutePath());
        syscoLabUI.findElement(By.xpath("//button[@title='Upload selected files']")).click();
        Thread.sleep(20000);
        syscoLabUI.quit();
    }

    @Test
    public void fileUploadExample2() throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setCapability("platformName", Platform.LINUX);
        SyscoLabUI syscoLabUI = new SyscoLabWUI(desiredCapabilities, false);
        syscoLabUI.getDriver().setFileDetector(new LocalFileDetector());
        //String filePath = "src/test/resources/selenium-snapshot.png";
        String filePath = "src/test/resources/test.csv";
        File file = new File(filePath);
        syscoLabUI.navigateTo("https://the-internet.herokuapp.com/upload");
        WebElement fileInput = syscoLabUI.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(file.getAbsolutePath());
        syscoLabUI.findElement(By.id("file-submit")).click();
        WebElement fileName = syscoLabUI.findElement(By.id("uploaded-files"));
        Assert.assertEquals("test.csv", fileName.getText());
        Thread.sleep(20000);
        syscoLabUI.quit();
    }

}
