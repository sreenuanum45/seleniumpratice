package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentwaitPratice_7 {
    @Test
    public void m1(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //define wit object
        FluentWait<ChromeDriver> w=new FluentWait<ChromeDriver>(driver);
        w.withTimeout(Duration.ofSeconds(20));
        w.pollingEvery(Duration.ofMillis(1000));
        //Launch site
        driver.get("http://www.gmail.com");
        WebElement e1=w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
        e1.sendKeys("7416472820");
        w.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']//parent::button"))).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Try again']")));
        driver.navigate().back();
        if(w.until(ExpectedConditions.stalenessOf(e1)))
        {
            System.out.println("stale element found");
            e1=w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
        }
        e1.clear();
        e1.sendKeys("sreenuanumandla45@gmail.com");
    }
}
