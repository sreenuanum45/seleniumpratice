package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_Attribute_Css_3 {
    RemoteWebDriver driver;
    @Test
    public void method(){
        driver.get("https://www.gmail.com");
        WebElement e=driver.findElement(By.xpath("//button[text()='Forgot email?']"));
        //before click
        String x1=e.getCssValue("color");
        String x2=e.getCssValue("background");
        System.out.println("color"+x1);
        System.out.println("background"+x2);
        //right click
        Actions as=new Actions(driver);
        as.contextClick().perform();
        String y1=e.getCssValue("color");
        String y2=e.getCssValue("background");
        System.out.println("color"+y1);
        System.out.println("background"+y2);
        if(!x1.equals(x2)&&!y1.equals(y2)){
      System.out.println("Test passed because of changes after right click");
        }
        else{
            System.out.println("Test fallied because of same after right click");
        }
    }
    @BeforeTest
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
}
