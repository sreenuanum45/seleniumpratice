package AdvanceSeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Actionclass_4_Flipkart {
    @Test
    public void m1() {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://www.flipkart.com/");
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@role='button']"))).click();
        }
        catch(Exception ex)
        {
            System.out.println("no banner");
        }
     //   ActionsUtility a=new ActionsUtility(driver,wait);
        Actions a=new Actions(driver);
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Fashion']")));
        a.moveToElement(e).perform();
        WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Men's Bottom Wear")));
        a.moveToElement(e2).perform();
        WebElement e3=wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("T-Shirts")));
        a.moveToElement(e3).perform();
        a.click(e3).perform();



    }
}
