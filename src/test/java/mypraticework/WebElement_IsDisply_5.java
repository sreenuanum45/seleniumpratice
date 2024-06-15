package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebElement_IsDisply_5 {
    RemoteWebDriver driver;

    @Test
    public void method1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://accounts.google.com/v3/signin/identifier?authuser=0&continue=https%3A%2F%2Fmail.google.com&ec=GAlAFw&hl=en&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S1526929216%3A1694357664951007&theme=glif");
        WebElement ee=driver.findElement(By.name("hiddenPassword"));
        if(ee.isDisplayed()){
            System.out.println("Element is visible in page");
        }
        else{
            System.out.println("Element not visible in page");
        }
    }

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    }

