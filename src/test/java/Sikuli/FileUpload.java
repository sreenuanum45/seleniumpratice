package Sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import java.awt.*;

public class FileUpload {
    @Test
    public void method1() throws InterruptedException, AWTException, FindFailed {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
        Thread.sleep(5000);
        driver.switchTo().frame("iframeResult");
        WebElement e = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
        Actions ac = new Actions(driver);
        ac.moveToElement(e).moveByOffset(-10, 0).click().build().perform();
        Screen s=new Screen();
        s.type("E:\\caputureimages\\filename.png","E:\\caputureimages\\signin.png");
        s.click("E:\\caputureimages\\open.png");
        driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();



    }
}
