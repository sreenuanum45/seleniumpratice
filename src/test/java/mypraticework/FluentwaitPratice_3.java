package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class FluentwaitPratice_3 {
    @Test
    public  void method1() {
        RemoteWebDriver driver = new ChromeDriver();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        driver.get("https://www.redbus.in");
        driver.manage().window().maximize();
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
       // System.out.println(driver.getTitle());
       // wait.until(ExpectedConditions.titleIs("Online Bus Ticket Booking at Low Price and Best Offers - redBus"));
        ExpectedCondition<Boolean>ec1=titleIs("Online Bus Ticket Booking at Low Price and Best Offers - redBus");
        ExpectedCondition<Boolean>ec2=urlContains("https");
        wait.until(and(ec1,ec2));
        WebElement ee=driver.findElement(By.tagName("h1"));
        ExpectedCondition<Boolean>ec3=attributeContains(ee,"text()","Bus Ticket Booking Site India's No. 1 Online ");

    }
}
