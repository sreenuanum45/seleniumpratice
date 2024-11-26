package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWait_Test {
    @Test(priority = 1)
    public void test1() {
        RemoteWebDriver driver = new ChromeDriver();

        /*FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver);

        wait.withTimeout(Duration.ofSeconds(30));

        wait.pollingEvery(Duration.ofSeconds(3));

        wait.ignoring(StaleElementReferenceException.class);*/
        //2nd way
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofSeconds(3));
        wait.ignoring(StaleElementReferenceException.class);
        //3way

      /*  Wait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofSeconds(3));
        wait.ignoring(StaleElementReferenceException.class);*/
        driver.get("https://www.facebook.com/");
        WebElement e=driver.findElement(By.id("email"));
        e.sendKeys(Keys.F5);
    }
}
