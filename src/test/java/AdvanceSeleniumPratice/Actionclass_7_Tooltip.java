package AdvanceSeleniumPratice;

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

public class Actionclass_7_Tooltip {
    @Test
    public void m1() {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://www.w3schools.com/css/tryit.asp?filename=trycss_tooltip");
//
        ActionsUtility obj=new ActionsUtility(driver,wait);
        driver.switchTo().frame("iframeResult");
        WebElement e1=driver.findElement(By.xpath("//div[@class='tooltip']"));
                wait.until(ExpectedConditions.visibilityOf(e1));
        System.out.println(e1.getText());

        WebElement e2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Tooltip text'])[2]")));;

        System.out.println(e2.getText());
        driver.switchTo().defaultContent();
        //close site
        driver.close();

    }
}
