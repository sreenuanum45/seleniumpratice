package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_GetSize_Location_Rect_3 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException {

        Thread.sleep(5000);
        driver.get("https://www.gmail.com");
        WebElement e =driver.findElement(By.name("hiddenPassword"));
       int xx= e.getSize().getHeight();
        int yy=e.getSize().getWidth();
        System.out.println(xx+"   "+yy);
       int x1 =e.getRect().getWidth();
        int y1=e.getRect().getHeight();
        System.out.println(x1+"  "+y1);
       int x =e.getLocation().getX();
       int y =e.getLocation().getY();
       System.out.println(x+"  "+y);
        int x2 =e.getRect().getX();
        int y2=e.getRect().getY();
        System.out.println(x2+"  "+y2);



    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
