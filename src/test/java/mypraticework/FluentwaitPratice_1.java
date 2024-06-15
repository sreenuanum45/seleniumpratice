package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentwaitPratice_1 {
    @Test
    public  void method1() {

        RemoteWebDriver driver = new ChromeDriver();
        FluentWait<RemoteWebDriver> wait=new FluentWait<>(driver);
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();

       wait.withTimeout(Duration.ofSeconds(20));
wait.pollingEvery(Duration.ofMillis(1000));

        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-button"))).click();


    }
}
