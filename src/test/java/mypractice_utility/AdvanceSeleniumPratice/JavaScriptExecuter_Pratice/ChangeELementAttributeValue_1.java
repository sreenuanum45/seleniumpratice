package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChangeELementAttributeValue_1 {
    @Test
    public void method() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://www.facebook.com/login/");
        WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.executeScript("arguments[0].setAttribute('type','search')",username);
        String x=username.getAttribute("type");
        if(x.equals("search")){
            System.out.println("pass");
        }
        else{
            System.out.println("fail");
        }

    }
}
