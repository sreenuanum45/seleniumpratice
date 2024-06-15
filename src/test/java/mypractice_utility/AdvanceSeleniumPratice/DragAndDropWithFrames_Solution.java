package mypractice_utility.AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;


public class DragAndDropWithFrames_Solution {
    @Test
    public void method1() throws InterruptedException, AWTException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {

            FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
            wait.withTimeout(Duration.ofSeconds(20));
            wait.pollingEvery(Duration.ofMillis(10));
            driver.get("https://codepen.io/rjsmer/full/vvewWp");
           /* wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("result"));
            driver.switchTo().frame(1);*/
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Up")));
            for (int i = 0; i < 10; i++) {
                driver.executeScript("arguments[0].innerText='" + i + "';", element);
                Thread.sleep(10000);
                Robot robot = new Robot();
                robot.mouseMove(166, 353);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                //Thread.sleep(50);
                robot.mouseMove(452, 361);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                Thread.sleep(5000);

            }
            driver.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            driver.close();
        }
    }
}
