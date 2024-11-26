package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class FluentwaitPratice_2 {
    @Test
    public  void method1() {
        RemoteWebDriver driver = new ChromeDriver();
/*        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));*/
        //Wait<WebDriver>wait=new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofSeconds(3000));
        Wait<RemoteWebDriver>wait= new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(1000));
        driver.get("https://blog.testproject.io/");
        driver.manage().window().maximize();
        String parentwindow=driver.getWindowHandle();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login"))).click();
        Set<String>windowhandles=driver.getWindowHandles();
        for (String window:windowhandles){
            if(window.equals(parentwindow)){
       driver.switchTo().window(window);
       wait.until(ExpectedConditions.textToBe(By.linkText("Login"),"Login"));
            }
        }
    }
}
