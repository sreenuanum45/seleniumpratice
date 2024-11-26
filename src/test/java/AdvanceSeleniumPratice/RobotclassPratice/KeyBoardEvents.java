package AdvanceSeleniumPratice.RobotclassPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class KeyBoardEvents {
    @Test
    public void method1() throws InterruptedException, AWTException, IOException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys("laplops");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.mouseWheel(100);
        robot.delay(3000);
        robot.mouseWheel(-30);

    }
}
