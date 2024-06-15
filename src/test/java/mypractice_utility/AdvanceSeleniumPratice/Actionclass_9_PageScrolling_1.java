package mypractice_utility.AdvanceSeleniumPratice;

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

public class Actionclass_9_PageScrolling_1 {
    @Test
    public void m1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));



        driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
        Actions a = new Actions(driver);
        WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact Us")));
        a.moveToElement(e).perform();
        Thread.sleep(5000);
        WebElement e2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Ask Question")));
        a.moveToElement(e2).perform();
        Thread.sleep(5000);
    }
}
