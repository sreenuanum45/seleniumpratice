package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebElement_Attribute_Css {
    RemoteWebDriver driver;
    @Test
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.gmail.com");
        WebElement e= driver.findElement(By.xpath("//button[text()='Forgot email?']"));
        String Av=e.getAttribute("type");
        System.out.println(Av);
        String cv=e.getCssValue("color");
        System.out.println(cv);
        driver.close();
    }
}

