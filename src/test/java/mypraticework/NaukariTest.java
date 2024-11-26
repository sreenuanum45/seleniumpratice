package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;


public class NaukariTest {

    RemoteWebDriver driver;
FluentWait<RemoteWebDriver> wait;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.ignoring(FindFailed.class);
        driver.manage().window().maximize();
    }
    @Test
    public void naukariTest() throws FindFailed, InterruptedException, AWTException {
        driver.get("https://www.naukri.com/");
        driver.findElement(By.xpath("//div[@class='acceptance-btn']/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("login_Layer")).click();
        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        driver.executeScript("arguments[0].scrollIntoView();", emailField);
        driver.executeScript("arguments[0].value='anumandlasreenu@gmail.com';", emailField);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        driver.executeScript("arguments[0].scrollIntoView();", passwordField);
        driver.executeScript("arguments[0].value='Sreenu45@';", passwordField);

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        driver.executeScript("arguments[0].scrollIntoView();", submitButton);
        driver.executeScript("arguments[0].click();", submitButton);
Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='other-info-wrapper']//a"))).click();
       Thread.sleep(2000);
        WebElement upload = driver.findElement(By.xpath("(//input[@type='button'])[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(upload).click().build().perform();
       driver.executeScript("arguments[0].scrollIntoView();", upload);
        driver.executeScript("arguments[0].style.border='3px solid green';", upload);

        driver.executeScript("arguments[0].click();", upload);


        // Use Sikuli to handle the file upload dialog
       /*Screen s = new Screen();
        s.type("E:\\caputureimages\\filename.png", "C:\\Users\\sreenu\\Downloads\\Anumandlasreenu.docx");
        s.click("C:\\Users\\sreenu\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-07-24 173515.png");*/
        Robot robot = new Robot();
        // Copy the file path to the clipboard
        StringSelection filePath = new StringSelection("C:\\Users\\sreenu\\Downloads\\Anumandlasreenu.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
        // Press Ctrl+V to paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        // Press Enter to confirm the upload
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

  /*  @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }*/
    }

