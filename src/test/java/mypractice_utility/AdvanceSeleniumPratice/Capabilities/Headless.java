package mypractice_utility.AdvanceSeleniumPratice.Capabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Headless {
    @Test
    public void test() throws InterruptedException {
        ChromeOptions o=new ChromeOptions();
        o.addArguments("--headless"); //native command as argument
        ChromeDriver driver=new ChromeDriver(o);
        Thread.sleep(5000);
        driver.get("http://www.google.co.in");
        Thread.sleep(5000);
        String x=driver.getTitle();
        System.out.println(x);
       String y= driver.getCurrentUrl();
       System.out.println(y);
       driver.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);
        driver.close();
    }
}
