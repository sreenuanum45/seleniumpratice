package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Webelement_GetShadowRoot_1 {
    RemoteWebDriver driver;
    @Test
    public  void method1() throws InterruptedException, IOException {
        Thread.sleep(5000);
        driver.get("chrome://settings/");
        WebElement e1=driver.findElement(By.tagName("settings-ui")) //Goto Shadow host
                .getShadowRoot() //Goto shadow root
                .findElement(By.id("toolbar")) //Goto Shadow host
                .getShadowRoot() //Goto Shadow root
                .findElement(By.id("search")) //Goto Shadow host
                .getShadowRoot() //Goto Shadow root
                .findElement(By.id("searchInput"));
        e1.sendKeys("sreenu");
        String x1= e1.getScreenshotAs(OutputType.BASE64);
        System.out.println(x1);
        byte[] b= e1.getScreenshotAs(OutputType.BYTES);
        try {
            FileOutputStream fos=new FileOutputStream("E:\\sreenuimages\\test0.png");
            fos.write(b);
        }catch (FileNotFoundException ex){
            ex.getStackTrace();
        }
    }
    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
