package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

public class FileUpload_2 {
    RemoteWebDriver driver;
    @Test
    public void FileUpload_2() throws AWTException {
        driver = new ChromeDriver();
        driver.get("https://www.foundit.in/web/en/home");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("(//a[@title='Click to upload your resume'])[1]")).click();
       // driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys("E:\\guru99bank\\SRS_v1.docx");
        driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//input[@type='file'])[1]")));
        StringSelection ss = new StringSelection("E:\\guru99bank\\SRS_v1.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }
}
