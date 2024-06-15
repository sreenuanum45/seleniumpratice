package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_GetText_2 {
    RemoteWebDriver driver;
    @Test
    public void method() {
        driver.get("https://www.gmail.com");
        WebElement e=driver.findElement(By.xpath("//button[@type='button']"));
        String x=e.getText();
        System.out.println(x);
    }
    @BeforeTest
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
}
