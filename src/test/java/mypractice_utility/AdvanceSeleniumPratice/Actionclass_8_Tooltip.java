package mypractice_utility.AdvanceSeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.ActionsUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Actionclass_8_Tooltip {
    @Test
    public void m1() {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://jqueryui.com/tooltip/");
        ActionsUtility obj = new ActionsUtility(driver, wait);
        WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ThemeRoller")));
        System.out.println(obj.getStaticToolTipText(e1));


    }
}
