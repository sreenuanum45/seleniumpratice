package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.ScreenShotUtility;
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

public class WebElement_GetScreenShot_1 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException, IOException {

        Thread.sleep(5000);
        driver.get("https://www.gmail.com");
        WebElement e = driver.findElement(By.xpath("//div/div[@id='logo']"));
        File src=e.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("E:\\sreenuimages\\srinu.png");
        FileHandler.copy(src,destinationFile);
        ScreenShotUtility.captureScreenshot(driver,"FULLPAGE","E:\\sreenuimages\\srinu1.png",e);
        ScreenShotUtility.visiblepageScreenshot("E:\\sreenuimages\\srinu2.png",driver);

    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
