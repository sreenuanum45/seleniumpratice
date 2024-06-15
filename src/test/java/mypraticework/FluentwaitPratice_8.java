package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentwaitPratice_8 {
    @Test
    public void m1() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //define wit object
        FluentWait<WebDriver> w = new FluentWait<>(driver);
        w.withTimeout(Duration.ofSeconds(20));
        w.pollingEvery(Duration.ofMillis(1000));
        //Launch site
        driver.get("http://www.gmail.com");
         w.until(Waitandfill(By.name("identifier"),"7416472820"));
         w.until(WaitandClick(By.xpath("//span[text()='Next']//parent::button")));
w.until(ExpectedConditions.urlContains("https"));
w.until(ExpectedConditions.titleIs("Gmail"));



    }
    public static ExpectedCondition WaitandClick(By b) {
        ExpectedCondition<Boolean> ee2 = new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver input) {
                try {
                    input.findElement(b).click();
                    return true;
                } catch (Exception e) {
                    return true;
                }
            }

            ;

        };
        return ee2;
    }

    public static ExpectedCondition<Boolean> Waitandfill(By b, String s) {
        ExpectedCondition<Boolean> ec1 = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    driver.findElement(b).sendKeys(s);
                    return true;
                } catch (Exception e) {
                    return false;
                }

            }
        };
        return ec1;
    }
}
