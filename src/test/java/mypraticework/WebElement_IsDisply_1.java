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

public class WebElement_IsDisply_1 {
    RemoteWebDriver driver;

    @Test
    public void method1() {
        driver.get("https://www.irctc.co.in/nget/train-search");

        WebElement e= driver.findElement(By.xpath("(//label[text()='PNR STATUS'])[1]"));

        String s1=(String) driver.executeScript("return(arguments[0].textContent);",e);
        System.out.println(s1);

        File src=e.getScreenshotAs(OutputType.FILE);
        File dest=new File("E:\\sreenuimages\\srinn121.png");
        try {
            FileHandler.copy(src,dest);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
      if(e.isDisplayed()){
          System.out.println("Element is visible in page");
      }
      else{
          System.out.println("Element not visible in page");
      }

    }

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }
}
