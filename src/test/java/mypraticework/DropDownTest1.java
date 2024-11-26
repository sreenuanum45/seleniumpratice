package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDownTest1 {
    @Test
    public void test1() {
        RemoteWebDriver driver=new ChromeDriver();
        driver.get("https://mdbootstrap.com/docs/standard/extended/multiselect/");
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver>wait=new FluentWait<RemoteWebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(StaleElementReferenceException.class);
        WebElement e=driver.findElement(By.xpath("(//select[@class='select-initialized'])[1]"));
 driver.executeScript("arguments[0].scrollIntoView(true);",e);
 wait.until(ExpectedConditions.elementToBeClickable(e));
                //(//select[@class='select-initialized'])[1]

    }
}
