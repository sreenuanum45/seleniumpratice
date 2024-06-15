package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.and;

public class FluentwaitPratice_3_GmailTest {
    @Test
    public  void method1() {
        RemoteWebDriver driver = new ChromeDriver();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        ExpectedCondition ec1 = ExpectedConditions.titleIs("Gmail");
        ExpectedCondition ec2 = ExpectedConditions.urlContains("https");
        wait.until(and(ec1, ec2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#identifierId"))).sendKeys("7416472820");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']"))).click();


    }
}
