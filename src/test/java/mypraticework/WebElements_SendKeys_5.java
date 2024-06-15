package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElements_SendKeys_5 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException {
        driver.get("https://www.flipkart.com");
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys("mobiles");
    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
