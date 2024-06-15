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
import java.io.FileOutputStream;
import java.io.IOException;

public class WebElement_GetScreenShot_6 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException, IOException {
        Thread.sleep(5000);
        driver.get("https://www.irctc.co.in/nget/train-search");
        WebElement e= driver.findElement(By.xpath("//div[@class='jp-radious']"));
        File src =e.getScreenshotAs(OutputType.FILE);
        File dust=new File("E:\\sreenuimages1111");
        FileHandler.copy(src,dust);
        String src1 =e.getScreenshotAs(OutputType.BASE64);
        System.out.println(src1);
       byte[] b=e.getScreenshotAs(OutputType.BYTES);
       try{
           FileOutputStream fos=new FileOutputStream("E:\\sreenuimages1");
           fos.write(b);
       }catch(IOException ex){
           ex.printStackTrace();
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
