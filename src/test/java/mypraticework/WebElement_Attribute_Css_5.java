package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_Attribute_Css_5 {
    RemoteWebDriver driver;
    @Test
    public void method() {
        driver.get("https://www.w3schools.com/css/tryit.asp?filename=trycss_before");
        driver.switchTo().frame("iframeResult");
        WebElement e=driver.findElement(By.xpath("(//h1[text()='This is a heading'])[1]"));
        String x=(String) driver.executeScript("var ps=window.getComputedStyle(arguments[0],'::before');"+"var s=ps.getPropertyValue('content');"+"return(s);",e);
        System.out.println(x);
        driver.switchTo().defaultContent();
        driver.close();
    }
    @BeforeTest
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
}
