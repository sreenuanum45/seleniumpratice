package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElements_SendKeys {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException {
        driver.get("https://www.facebook.com/");

        WebElement ee=driver.findElement(By.id("email"));
        Thread.sleep(2000);
        ee.sendKeys("7416472820");
        ee.sendKeys(Keys.TAB,"Sreenu45@",Keys.TAB,Keys.TAB,Keys.ENTER);

    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
