package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_GetSize_Location_Rect_2 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException {

        Thread.sleep(5000);
        driver.get("https://www.google.co.in/");
        WebElement e= driver.findElement(By.name("q"));
       int xx =e.getSize().getWidth();
        int yy=e.getSize().getHeight();
        System.out.println(xx+"  "+yy);
       int xx1= e.getRect().getWidth();
        int yy1=e.getRect().getHeight();
        System.out.println(xx1+" "+yy1);
        int x=e.getRect().getX();
        int y=e.getRect().getY();
      System.out.println(x+" "+y);
      int x1=e.getLocation().getX();
        int y1=e.getLocation().getY();
        System.out.println(x1+" "+y1);
        String s1=e.getText();
        System.out.println(s1);
    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
