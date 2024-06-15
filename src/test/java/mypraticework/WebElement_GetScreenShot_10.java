package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class WebElement_GetScreenShot_10 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException, IOException {

        Thread.sleep(5000);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
        driver.switchTo().frame("iframeResult");
        WebElement e=driver.findElement(By.id("lname"));
       File src= e.getScreenshotAs(OutputType.FILE);
       File dust=new File("E:\\sreenuimages\\4.png");
        FileHandler.copy(src,dust);

    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
