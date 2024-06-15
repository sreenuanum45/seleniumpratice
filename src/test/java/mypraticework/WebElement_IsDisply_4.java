package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebElement_IsDisply_4 {
    RemoteWebDriver driver;

    @Test
    public void method1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.irctc.co.in/");
        List<WebElement> l=driver.findElements(By.xpath("//*"));

        int invisible=0;
        int visible = 0;
        for(WebElement e:l){
            if(e.isDisplayed()){
                visible++;
            }
            else{
                invisible++;
            }

        }
         System.out.println(visible);
        System.out.println(invisible);
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
