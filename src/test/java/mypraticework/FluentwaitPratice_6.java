package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class FluentwaitPratice_6 {
    @Test
    public  void method1() {
        ChromeDriver driver = new ChromeDriver();
        FluentWait<ChromeDriver> wait = new FluentWait<ChromeDriver>(driver);
        driver.get("https://www.google.co.in");
        driver.manage().window().maximize();
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        //WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        ExpectedCondition<Boolean> e1 = invisibilityOfElementLocated(By.name("q"));
        ExpectedCondition<WebElement> e2 = elementToBeClickable(By.linkText("Gmail"));
        ExpectedCondition<Boolean>e3=invisibilityOfElementLocated(By.linkText("Gmail"));
        wait.until(not(e3));
    }
}
