package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class ElementScrolling_1 {
    @Test
    public void method() throws InterruptedException, AWTException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Thread.sleep(5000);
        WebElement e=driver.findElement(By.id("twotabsearchtextbox"));

        driver.executeScript("arguments[0].scrollIntoView(true);",e);
        driver.executeScript("var x=arguments[0].scrollHeight; arguments[0].scrollTop=x;",e);
        Thread.sleep(5000);
        driver.executeScript("arguments[0].scrollTop=0;",e);
        Thread.sleep(5000);
        driver.executeScript("var x=arguments[0].scrollWidth; arguments[0].scrollLeft=x;",e);
        Thread.sleep(5000);
        driver.executeScript("arguments[0].scrollLeft=0;",e);
//pagescrolling in selenium
        driver.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(5000);
        driver.executeScript("window.scrollTo(0,-(document.body.scrollHeight));");
        Thread.sleep(5000);
        driver.executeScript("window.scrollTo(document.body.scrollWidth,0);");
        Thread.sleep(5000);
        driver.executeScript("window.scrollTo(document.body.scrollWidth,document.body.scrollHeight);");
        Thread.sleep(5000);
        driver.executeScript("window.scrollTo(document.body.scrollWidth,-(document.body.scrollHeight));");




    }
}
