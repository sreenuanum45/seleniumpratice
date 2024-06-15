package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebElements_Clear_0 {
    RemoteWebDriver driver;

    @Test
    public void method1() throws InterruptedException {
        driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.get("https://www.gmail.com");
        //"ElementNotInteractableException" due to clear a hidden element
        driver.findElement(By.name("hiddenPassword")).clear();
    }

    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
