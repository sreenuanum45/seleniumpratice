package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentwaitPratice_1_A {
    @Test
    public void method1() {
        RemoteWebDriver driver = new ChromeDriver();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(200));
        wait.pollingEvery(Duration.ofMillis(10000));

        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email"))).sendKeys("7416472820");
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pass"))).sendKeys("Sreenu45@");
wait.until(ExpectedConditions.presenceOfElementLocated(By.name("login"))).click();
wait.until(ExpectedConditions.textToBe(By.xpath("(//div[@role='none'])[4]"),"Try another way"));

    }
}
