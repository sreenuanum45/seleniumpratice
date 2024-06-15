package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class PageZoom_1AndCreateAlert {
    @Test
    public void method() throws InterruptedException, AWTException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        Thread.sleep(5000);
        driver.executeScript("document.body.style.zoom='200%';");
        driver.executeScript("window.alert('new alert');");
        Thread.sleep(5000);
        String x=driver.switchTo().alert().getText();
        System.out.println(x);
        driver.switchTo().alert().dismiss();
        driver.executeScript("history.go(0);");




    }
}
