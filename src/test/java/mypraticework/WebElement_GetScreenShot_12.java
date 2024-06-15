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

public class WebElement_GetScreenShot_12 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException, IOException {

        Thread.sleep(5000);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
        driver.switchTo().frame("iframeResult");
        WebElement e = driver.findElement(By.id("lname"));
        byte[] src = e.getScreenshotAs(OutputType.BYTES);
        try{
            FileOutputStream fos=new FileOutputStream("E:\\sreenuimages\\pratice1.png");
            fos.write(src);
        }catch (IOException ee){
            ee.printStackTrace();
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
