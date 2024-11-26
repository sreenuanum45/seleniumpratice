package AdvanceSeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.ActionsUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Actionclass_5_Google {
    @Test
    public void m1() {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://www.google.co.in");
        ActionsUtility a=new ActionsUtility(driver,wait);
        WebElement e1= wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Images")));
        a.focusOnElementCenter(e1);
        WebElement e2= wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        a.clickOnElement(e2);
        WebElement e3=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Gmail")));
        a.doubleClickOnElement(e3);
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")))
                .sendKeys("bse sensex", Keys.ENTER);
WebElement e4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='uch-svg']//following::*[name()='svg']//*[name()='g'])[1]")));
a.focusOnElementLocation(e4,-250,100);

    }
}
