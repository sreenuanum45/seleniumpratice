package AdvanceSeleniumPratice;

import mypractice_utility.ActionsUtility;
import mypractice_utility.RangeSliderUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class RangeSlidertest_2 {
    @Test
    public void method1() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/slider/");
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        RangeSliderUtility Rs = new RangeSliderUtility();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.id("slider")));
       // Actions ac = new Actions(driver);
//RangeSliderUtility rs=new RangeSliderUtility();
//rs.setRangeSliderValue(e,25,driver);
        //ac.moveToElement(e,10,0);
        ActionsUtility ac=new ActionsUtility(driver,wait);
        ac.moveSlider(e,100,0);
        Thread.sleep(10000);
        ac.moveSlider(e,-100,0);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Vertical slider"))).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-slider-range ui-corner-all ui-widget-header ui-slider-range-min']")));
   ac.moveSlider(e2,0,100);
   Thread.sleep(10000);

   ac.moveSlider(e2,0,-100);

   driver.switchTo().defaultContent();
    }
}
