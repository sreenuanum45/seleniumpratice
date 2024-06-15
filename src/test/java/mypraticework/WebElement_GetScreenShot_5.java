package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class WebElement_GetScreenShot_5 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException, IOException {

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com");
        WebElement e=driver.findElement(By.id("container"));
       byte src[]= e.getScreenshotAs(OutputType.BYTES);
        try (FileOutputStream fos = new FileOutputStream("E:\\sreenuimages\\sri.png")) {
            fos.write(src);
            System.out.println("Screenshot saved as a file.");
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
