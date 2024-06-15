package mypractice_utility.AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RelativeLocators_1 {
    @Test
    public void method() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://www.google.co.in");
        WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//form[@role='search']//*[name()='svg'])[1]")));
        WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Search by voice']//*[name()='svg']")));
        RelativeLocator.RelativeBy rb=RelativeLocator.with(By.xpath("//textarea"));
        List<WebElement> targets=driver.findElements(rb.toRightOf(e).toLeftOf(e1));
        System.out.println(targets.size());
        for(WebElement target:targets)
        {
            driver.executeScript("arguments[0].style.border='5px dotted blue';",target);
            Thread.sleep(5000);
        }
        /*WebElement e12=driver.findElement(By.name("q"));
        RelativeLocator.RelativeBy relativeBy=RelativeLocator.with(By.tagName("svg"));
        List<WebElement> targetsList=driver.findElements(rb.near(e12,100));
        System.out.println(targetsList.size());
        for(WebElement target1:targetsList)
        {
            driver.executeScript("arguments[0].style.border='2px solid red';", target1);
            Thread.sleep(5000);
        }
        targetsList.get(0).click(); //2nd target element (mic)*/

    }
}
