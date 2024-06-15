package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

;

public class RelativeLocators_1 {
    @Test
    public void method1() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://www.t-mobile.com/guestpay");
        WebElement e= driver.findElement(By.className("mat-button-wrapper"));
        e.click();

    }
}
