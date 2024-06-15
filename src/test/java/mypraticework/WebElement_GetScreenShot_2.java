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
import java.time.Duration;

public class WebElement_GetScreenShot_2 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException, IOException {

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement e=driver.findElement(By.xpath("//div[@class='orangehrm-login-slot-wrapper']"));
      File src=  e.getScreenshotAs(OutputType.FILE);
      File dest=new File("E:\\sreenuimages\\srinn.png");
        FileHandler.copy(src,dest);
        ScreenShotUtility.fullPageScreenshot(driver,"E:\\sreenuimages\\sri1.png" );
        ScreenShotUtility.visiblepageScreenshot("E:\\sreenuimages\\sri2.png",driver);
        ScreenShotUtility.captureScreenshotInFile(e,"E:\\sreenuimages\\sri3.png");

    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }

}
