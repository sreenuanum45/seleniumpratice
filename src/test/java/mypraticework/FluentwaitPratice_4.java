package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentwaitPratice_4 {
    @Test
    public  void method1()throws StaleElementReferenceException {
        RemoteWebDriver driver = new ChromeDriver();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        driver.manage().window().maximize();
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_ContentPlaceholder1_RadCalendar1_Top")));
        WebElement e=driver.findElement(By.cssSelector("#ctl00_ContentPlaceholder1_RadCalendar1_Top"));
        driver.executeScript("arguments[0].scrollIntoView();",e);
        WebElement ee=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("7")));
        driver.executeScript("arguments[0].click();",ee);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".raDiv")));
        String x=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".kd-switch-button"))).getCssValue("color");
System.out.println(x);
WebElement e1=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".kd-switch-button")));
e1.click();
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".kd-switch-button"))).getCssValue("color"));


       // driver.close();
    }
}
