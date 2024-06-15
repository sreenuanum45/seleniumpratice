package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebElement_Attribute_Css_2 {
    RemoteWebDriver driver;
    @Test
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
        WebElement e= driver.findElement(By.xpath("//div[@jsname='RNNXgb']"));
        String x=e.getCssValue("box-shadow"); //no shadow
        System.out.println(x);
        Actions ac=new Actions(driver);
        ac.moveToElement(e).perform();
        String y=e.getCssValue("box-shadow"); //no shadow
        System.out.println(y);
         if(!y.contains("none")){
             System.out.println("test passed  because of shading ");
         }
         else{
             System.out.println("Test failed due to no shading");
         }
        
    }

}
