package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Psuedo_2 {
    RemoteWebDriver driver;

    @Test(priority = 1)
    public void method1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/");
        WebElement e=driver.findElement(By.linkText("Learn more"));
        String s = (String) driver.executeScript("var ps = window.getComputedStyle(arguments[0], '::after'); var s = ps.getPropertyValue('color'); return s;", e);

        System.out.println(s);
    }
}
