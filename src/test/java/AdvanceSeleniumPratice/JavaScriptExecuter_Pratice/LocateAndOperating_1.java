package AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LocateAndOperating_1 {
    @Test
    public void method() throws Exception {
        //Open browser and launch site
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in");
        Thread.sleep(5000);
        driver.executeScript("document.getElementsByName('q')[0].value='kalam sir';");
        Thread.sleep(5000);
        driver.executeScript("document.getElementsByClassName('gNO89b')[0].click();");
    }

    }
