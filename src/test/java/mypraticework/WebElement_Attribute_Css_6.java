package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_Attribute_Css_6 {
    RemoteWebDriver driver;
    @Test
    public void method() {
        driver.get("https://www.facebook.com/login.php");
        WebElement e=driver.findElement(By.linkText("Forgotten account?"));
       String x1= e.getCssValue("color");
       String y1=e.getCssValue("text-decoration");
       System.out.println(x1);
        System.out.println(y1);
        Actions ac=new Actions(driver);
        ac.moveToElement(e).perform();
        String x2= e.getCssValue("color");
        String y2=e.getCssValue("text-decoration");
        System.out.println(x2);
        System.out.println(y2);
        if(!y2.contains("none")){
            System.out.println("test passed because change");
        }
        else{
            System.out.println("test failed dont  change");
        }

    }
    @BeforeTest
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
}
