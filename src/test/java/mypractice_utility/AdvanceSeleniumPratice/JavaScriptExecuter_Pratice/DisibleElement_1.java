package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DisibleElement_1 {
    @Test
    public void method() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://www.facebook.com/login/");
        WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.executeScript("arguments[0].disabled=true;",username);
        Thread.sleep(5000);
        driver.executeScript("arguments[0].disabled=false;",username);


        username.sendKeys("7416472820");

        WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        driver.executeScript("arguments[0].disabled=true;",password);
        Thread.sleep(5000);
        driver.executeScript("arguments[0].disabled=false;",password);
        password.sendKeys("Sreenu45@");
        WebElement ee=driver.findElement(RelativeLocator.with(By.id("loginbutton")).below(password));
        driver.executeScript("arguments[0].style.border='5px dotted blue';",ee);
        Thread.sleep(5000);
        driver.executeScript("arguments[0].disabled=true;",ee);
        Thread.sleep(5000);
        driver.executeScript("arguments[0].disabled=false;",ee);
        ee.submit();


    }
}
