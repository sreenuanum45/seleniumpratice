package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DatePickerDemo_2 {
    @Test
    public void datePickerDemo() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dummy-tickets.com/");
        //https://www.dummyticket.com/dummy-ticket-for-visa%20application/
WebElement element=driver.findElement(By.xpath("(//input[@name='source[]'])[1]"));
element.click();
element.sendKeys("Delhi");

    }
}
