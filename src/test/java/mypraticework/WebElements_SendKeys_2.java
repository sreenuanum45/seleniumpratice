package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElements_SendKeys_2 {
    RemoteWebDriver driver;

    @Test
    public void method1() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("anumandlasreenu", Keys.chord(Keys.CONTROL,"C"));
        Thread.sleep(3000);
        driver.findElement(By.id("pass")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
driver.findElement(By.name("login")).click();
    }

    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
