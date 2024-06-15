package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentwaitPratice_10_Facebook {
    @FindBy(css = "#email")
    private WebElement uid;
    @FindBy(css = "#pass")
    private WebElement pwd;
    public void fill(RemoteWebDriver driver) {
        FluentWait<RemoteWebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
      uid=wait.until((RemoteWebDriver d)->{
         WebElement e=d.findElement(By.cssSelector("#email"));
         String x=e.getAttribute("aria-label");
         return (x!=null && x.contains("Email address or phone number"))?e:null;
     });
      uid.sendKeys( "7416472820");

    }
    @Test
    public void m1() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        fill(driver);
    }
}
