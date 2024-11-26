package AdvanceSeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Actionclass_9_PageScrolling {
    @Test
    public void m1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
        Actions a=new Actions(driver);
        /*a.sendKeys(Keys.DOWN).perform();
        a.sendKeys(Keys.UP).perform();*/
        a.sendKeys(Keys.END).perform();
        Thread.sleep(5000);
        a.sendKeys(Keys.HOME).perform();

    }
}
