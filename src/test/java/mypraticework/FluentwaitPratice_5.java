package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class FluentwaitPratice_5 {
    @Test
    public  void method1(){
        ChromeDriver driver = new ChromeDriver();
        FluentWait<ChromeDriver> wait = new FluentWait<ChromeDriver>(driver);
        driver.get("https://www.google.co.in");
        driver.manage().window().maximize();
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        //WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        ExpectedCondition<WebElement>e1= elementToBeClickable(By.name("q"));
        ExpectedCondition<WebElement>e2= elementToBeClickable(By.linkText("Gmail"));

       //WebElement e2= wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Gmail")));
        wait.until(and( e1,  e2));
        wait.until(or( e1,  e2));
       // e1.sendKeys("selenium", Keys.ENTER);
    }
}
