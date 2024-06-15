package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_Attribute_Css_4 {
    RemoteWebDriver driver;
    @Test
    public void method() {
        driver.get("https://www.gmail.com");
        WebElement e = driver.findElement(By.xpath("//button[text()='Forgot email?']"));
        //before click
        String x1 = e.getCssValue("color");
        String x2 = e.getCssValue("background");
        System.out.println("color" + x1);
        System.out.println("background" + x2);
        driver.findElement(By.name("identifier")).sendKeys(Keys.TAB);

        String y1 = e.getCssValue("color");
        String y2 = e.getCssValue("background");
        System.out.println("color" + y1);
        System.out.println("background" + y2);
        String y3 = (String) driver.executeScript(
                "var ps = window.getComputedStyle(arguments[0], '::after');" +
                        "var s = ps.getPropertyValue('color');" +
                        "return (s);", e);
        System.out.println(y3);
    }
    @BeforeTest
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
}
