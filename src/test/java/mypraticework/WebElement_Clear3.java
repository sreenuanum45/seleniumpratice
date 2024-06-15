package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class WebElement_Clear3 {



    @Test
    public void method1() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        RemoteWebDriver driver= new EdgeDriver ();
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.get("https://www.flipkart.com/");
      driver.findElement(By.name("q")).sendKeys("mobile", Keys.BACK_SPACE,Keys.ENTER);
        driver.findElement(By.name("q")).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.CONTROL,"c");
      System.out.println(Keys.chord(Keys.CONTROL,"v"));

    }
}
