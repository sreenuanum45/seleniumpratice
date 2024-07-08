package mypractice_utility.AdvanceSeleniumPratice.SeleniumListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void method() throws InterruptedException {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(co);
        driver.manage().window().maximize();

        MyWebDriverListener listener = new MyWebDriverListener();
        WebDriver decorated = new EventFiringDecorator<>(listener).decorate(driver);


        decorated.get("https://www.flipkart.com");
        WebElement e = decorated.findElement(By.linkText("Cart"));
     try {
            e.click();
        } catch (Exception e1) {
            // Handle exception
        }
        Thread.sleep(5000);
        driver.quit();
    }
}

