package AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertCreate_1 {
    @Test
    public void m1() throws InterruptedException {//Open browser and Launch site
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.executeScript("window.alert('site ready to launch');");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

        driver.get("https://www.google.co.in");
        Thread.sleep(5000);
        driver.executeScript("window.alert('search the word');");
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        driver.executeScript("window.alert('close the site');");
        Thread.sleep(5000);

        driver.switchTo().alert().dismiss();
        driver.close();
    }
}
