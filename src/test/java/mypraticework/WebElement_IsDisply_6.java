package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_IsDisply_6 {
    RemoteWebDriver driver;

    @Test
    public void method1() throws InterruptedException {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
        Thread.sleep(5000);
        //"InvalidElementStateException" because we try to clear a disabled element
        driver.switchTo().frame("iframeResult");
        WebElement e=driver.findElement(By.name("lname"));
        if(e.isDisplayed()){
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

