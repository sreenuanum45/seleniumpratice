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

public class Webelement_GetShadowRoot {
    RemoteWebDriver driver;
    @Test
    public  void method1() throws InterruptedException, IOException {
        Thread.sleep(5000);
        driver.get("https://books-pwakit.appspot.com");

        WebElement e=driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']")).getShadowRoot().
                findElement(By.id("input"));
        e.sendKeys("abdul kalam");
       String x1= e.getScreenshotAs(OutputType.BASE64);
       System.out.println(x1);
        byte[] b= e.getScreenshotAs(OutputType.BYTES);
        try {
            FileOutputStream fos=new FileOutputStream("E:\\sreenuimages\\test1.png");
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
