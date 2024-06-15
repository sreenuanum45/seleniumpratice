package mypractice_utility.AdvanceSeleniumPratice.RobotclassPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload2 {
    @Test
    public void method1() throws InterruptedException, AWTException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
        Thread.sleep(5000);
        driver.switchTo().frame("iframeResult");
        WebElement e=driver.findElement(By.xpath("(//input[@type='file'])[1]"));
        Actions ac=new Actions(driver);
        ac.moveToElement(e).moveByOffset(-10,0).click().build().perform();
        StringSelection ss=new StringSelection("E:\\caputureimages\\Screenshot 2024-01-17 191108.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);

        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);

        Thread.sleep(5000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);


    }
}
