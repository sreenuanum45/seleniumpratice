package mypractice_utility.AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class CssVsXpath {
    @Test
    public void method() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://www.google.co.in");
        Instant starttime=Instant.now();
        System.out.println(starttime.toString());
       WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        //WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='q']")));

        e.sendKeys("bse sensex", Keys.ENTER);
        Instant endtime=Instant.now();
        System.out.println(endtime.toString());
        Duration d=Duration.between(starttime,endtime);
        System.out.println(d.toString());
    }
}
