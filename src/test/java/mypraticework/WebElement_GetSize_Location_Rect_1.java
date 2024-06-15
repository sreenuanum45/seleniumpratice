package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_GetSize_Location_Rect_1 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException {

        Thread.sleep(5000);
        driver.get("https://www.gmail.com");
        WebElement e=driver.findElement(By.name("identifier"));
        e.sendKeys("sreenuanumandla45@gmail.com");
        int x=e.getRect().getHeight();
        int y=e.getRect().getWidth();
        System.out.println(x+"   "+y);
    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
