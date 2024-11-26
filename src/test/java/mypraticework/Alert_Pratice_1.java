package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alert_Pratice_1 {
   @Test
    public void method1() {
        RemoteWebDriver driver=new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver>wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(1000));
                wait.until(ExpectedConditions.elementToBeClickable(By.id("alertexamples"))).click();

       String text=driver.switchTo().alert().getText();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        System.out.println(text);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmexample"))).click();
        String text2=wait.until(ExpectedConditions.alertIsPresent()).getText();
        Assert.assertEquals(text2,"I am a confirm alert");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("promptexample"))).click();
        wait.until(ExpectedConditions.alertIsPresent()).sendKeys("hello");
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        String text3=wait.until(ExpectedConditions.alertIsPresent()).getText();
        Assert.assertEquals(text3,"hello");
    }
}
