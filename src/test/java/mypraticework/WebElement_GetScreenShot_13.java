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

public class WebElement_GetScreenShot_13 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException, IOException {
        Thread.sleep(5000);
        driver.get("https://accounts.google.com/v3/signin/identifier?authuser=0&continue=https%3A%2F%2Fmail.google.com&ec=GAlAFw&hl=en&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S1526929216%3A1694357664951007&theme=glif");
        WebElement ee=driver.findElement(By.name("hiddenPassword"));
        byte[] src = ee.getScreenshotAs(OutputType.BYTES);
        try{
            FileOutputStream fos=new FileOutputStream("\"E:\\sreenuimages\\srrrr.png\"");
            fos.write(src);
        }catch (IOException ee1){
            ee1.printStackTrace();
        }

       String ss= ee.getScreenshotAs(OutputType.BASE64);
       System.out.println(ss);


    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
