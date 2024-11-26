package AdvanceSeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.ActionsUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Actionclass_6_Jqueryui {
    @Test
    public void m1() {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://jqueryui.com/droppable/");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));
        WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
        WebElement e2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
        ActionsUtility a=new ActionsUtility(driver,wait);
        a.dragDrop(driver,e1,e2);
        Assert.assertEquals(e2.getCssValue("background-color"),"rgba(0, 255, 0, 1)");
    }
}
