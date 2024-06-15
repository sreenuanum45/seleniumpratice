package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentwaitPratice_9_Facebook {

    @Test
    public void m1() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        FluentWait<ChromeDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));

        driver.get("https://www.facebook.com");

        WebElement uid = wait.until((ChromeDriver d) -> {
            WebElement e = d.findElement(By.cssSelector("#email"));
            String x = e.getAttribute("aria-label");
            return (x != null && x.contains("Email address or phone number")) ? e : null;
        });

        if (uid != null) {
            uid.sendKeys("7416472820",Keys.TAB,"Sreenu45@", Keys.ENTER);
        }

    }
}
