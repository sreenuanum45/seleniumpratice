package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentwaitPratice_2_A {
    @Test
    public void method1() {
        RemoteWebDriver driver = new ChromeDriver();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        driver.get("https://www.javatpoint.com/oprweb/test.jsp?filename=html-registration-form1");
        driver.manage().window().maximize();
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.switchTo().frame("iframewrapper");
       WebElement firstname = wait.until(new Function<RemoteWebDriver, WebElement>() {
            @Override
            public WebElement apply(RemoteWebDriver driver) {
                return driver.findElement(By.name("firstname"));
            }
        });
       firstname.sendKeys("sreenu");
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys("anumandla");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("middlename"))).sendKeys("srenu");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname"))).sendKeys("sreenu");
        Select s=new Select(driver.findElement(By.tagName("select")));
        s.selectByValue("B.Tech");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("male"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("country code"))).sendKeys("+91");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone"))).sendKeys("7416472820");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea"))).sendKeys("hyderabad");
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//span[@class='glyphicon glyphicon-triangle-right']//parent::button"))).click();
        driver.navigate().to("https://www.facebook.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email"))).sendKeys("7416472820");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pass"))).sendKeys("Sreenu45@");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("login"))).click();



    }
}
