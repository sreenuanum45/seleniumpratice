package AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Framelength {
    @Test

        public void m1()  {//Open browser and Launch site
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
      List<WebElement> l1 =driver.findElements(By.tagName("iframe"));
      System.out.println(l1.size());
        Long x=(Long)driver.executeScript("return(window.frames.length)");
        System.out.println(x);
        driver.close();
    }
}
