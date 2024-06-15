package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_IsDisply_2 {
    RemoteWebDriver driver;

    @Test
    public void method1() {
        driver.get("https://www.google.co.in/");
        WebElement e=driver.findElement(By.xpath("(//div[@id='gb']/descendant::a)[3]"));
        if(e.isDisplayed()){
            System.out.println("element visible in page");
            if(e.isEnabled())
            {
                System.out.println("Element is enabled in page");
            }
            else
            {
                System.out.println("Element is disabled in page");
            }
        }
        else{
            System.out.println("element not visible in page");
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
