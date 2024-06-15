package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElements_SendKeys_3 {
    RemoteWebDriver driver;
    @Test
    public void method1() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.gmail.com");
        //element present in pagesource not in page  we get Element intercatable Exception
        driver.findElement(By.name("hiddenPassword")).sendKeys("abdulkalam");
    }
    @BeforeTest
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }

    }
