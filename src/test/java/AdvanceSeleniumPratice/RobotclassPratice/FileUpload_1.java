package AdvanceSeleniumPratice.RobotclassPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class FileUpload_1 {
    @Test
    public void method1() throws InterruptedException, AWTException, IOException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        WebElement e= driver.findElement(By.xpath("(//input[@type='file'])[1]"));
       e.sendKeys("E:\\sreenuimages\\image17.jpg");



    }
}
