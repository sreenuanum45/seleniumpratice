package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Webelement_GetAccessibleName_getAriaRole_1 {
    RemoteWebDriver driver;
    @Test
    public  void method1() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ifkv=AYZoVhdrnvYpWsvry9JGryFzqbbvlzQv3cvs52-82wXtlW7hRj9ls26QYQyKWISWhyE2dTk_TjFZKg&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S2131598976%3A1694447668881496&theme=glif");
        WebElement e=driver.findElement(By.id("identifierId"));
       String x= e.getAccessibleName();
       System.out.println(x);
        String y= e.getAriaRole();
        System.out.println(y);
    }
    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
