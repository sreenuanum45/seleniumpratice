package AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class PageScrolling_1 {
    @Test
    public void method() throws InterruptedException, AWTException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        Thread.sleep(5000);
        org.openqa.selenium.Dimension d=new Dimension(500,600);
        driver.manage().window().setSize(d);
        driver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(5000);
        driver.executeScript("window.scrollTo(0,-(document.body.scrollHeight))");
        Thread.sleep(5000);
        driver.executeScript("window.scrollTo(document.body.scrollWidth,0)");
        Thread.sleep(5000);
        driver.executeScript("(window.scrollTo-(document.body.scrollWidth),0)");
       /* Robot r=new Robot();
     r.keyPress(KeyEvent.VK_PAGE_DOWN);
        r.keyRelease(KeyEvent.VK_PAGE_DOWN);*/
    }
}
