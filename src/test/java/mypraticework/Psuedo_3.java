package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Psuedo_3 {

    RemoteWebDriver driver;

    @Test(priority = 1)
    public void method1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/CSS/tryit.asp?filename=trycss_before");
        driver.switchTo().frame("iframeResult");
        WebElement e=driver.findElement(By.xpath("(//h1[text()='This is a heading'])[1]"));
        String s = (String) driver.executeScript("var ps = window.getComputedStyle(arguments[0], '::before'); var s = ps.getPropertyValue('content'); return (s);", e);
        System.out.println(s);
    }
}
