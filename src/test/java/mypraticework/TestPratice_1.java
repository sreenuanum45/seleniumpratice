package mypraticework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPratice_1 {
    @Test
    public  void method1(){
        RemoteWebDriver driver=new ChromeDriver();
        FluentWait<RemoteWebDriver>wait=new FluentWait<>(driver);
        driver.manage().window().maximize();
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://www.flipkart.com");
        wait.until(ExpectedConditions.urlContains("https"));
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.titleIs("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"));

    }
}
