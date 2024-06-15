package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_IsDisply_3 {
    RemoteWebDriver driver;

    @Test
    public void method1() {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");
        driver.switchTo().frame("iframeResult");
        WebElement e=driver.findElement(By.id("age3"));
        e.click();
        if(e.isDisplayed()) {
            if (e.isEnabled()) {
                if (e.isSelected()) {
                    System.out.println("element is visible in page and is enabled and selected");
                } else {
                    System.out.println("element is visible in page and is enabled and  not selected");
                }

            } else {
                System.out.println("element is visible in page and is not enabled");
            }
        }
            else{
                System.out.println("element is  not visible in page ");
            }

         driver.close();

    }

    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }
}
