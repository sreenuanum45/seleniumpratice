package AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDropWithFrames {
    @Test
    public void method1() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://codepen.io/rjsmer/full/vvewWp");
        Actions ac=new Actions(driver);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Up")));
        for (int i = 0; i < 9; i++) {
            driver.executeScript("arguments[0].innerText='" + i + "';", element);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("result"));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
            WebElement drag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dragFrame-" + i)));
            System.out.println(drag.getLocation());

            ac.clickAndHold(drag).moveByOffset(70, 68).perform();
            driver.executeScript("arguments[0].style.border='5px dotted yellow';", drag);
            driver.switchTo().parentFrame(); //back to outer frame
            driver.switchTo().frame(1); //2nd inner frame in page
            //WebElement drop=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='element2-1']//parent::ul")));
            //  WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element2-1")));
            WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' DROP INTO THIS FRAME']")));
            System.out.println(drop.getLocation());

            ac.moveToElement(drop).release().perform();
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
        }




    }
}
