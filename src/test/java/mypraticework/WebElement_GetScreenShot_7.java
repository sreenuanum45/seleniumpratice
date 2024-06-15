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

public class WebElement_GetScreenShot_7 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException, IOException {
        Thread.sleep(5000);
        driver.get("https://www.youtube.com");
        WebElement e=driver.findElement(By.xpath("(//a[@id='thumbnail'])[4]"));

        File src =e.getScreenshotAs(OutputType.FILE);
        File dust=new File("E:\\sreenuimages\\sreenuimages1111.png");
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
