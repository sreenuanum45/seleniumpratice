package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class TestPratice_2 {
    @Test
    public  void method1(){
        RemoteWebDriver driver=new ChromeDriver();
        driver.get("https://myaccount.google.com");
        FluentWait<RemoteWebDriver>wait=new FluentWait<>(driver);

        wait.until(invisibilityOfElementLocated(By.name("q")));
        ExpectedConditions ec1= (ExpectedConditions) titleContains("https");
        System.out.println(ec1);
    }
}
