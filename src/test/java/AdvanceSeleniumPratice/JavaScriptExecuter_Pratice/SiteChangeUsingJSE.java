package AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SiteChangeUsingJSE{
    @Test
    public void m1() throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
        Thread.sleep(5000);
        driver.navigate().to("https://www.amazon.in");
        Thread.sleep(5000);
        driver.executeScript("window.open('https://www.flipkart.com');");
        Thread.sleep(5000);
        driver.executeScript("window.location='https://www.google.co.in';");
        Thread.sleep(5000);
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
}
