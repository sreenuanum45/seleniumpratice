package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Pagenation_WebTable {
    @Test
    public void webTable() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
    driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
}
