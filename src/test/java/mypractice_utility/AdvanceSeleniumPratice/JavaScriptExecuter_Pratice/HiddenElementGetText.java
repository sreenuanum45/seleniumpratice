package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HiddenElementGetText {
    @Test
    public void method() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://semantic-ui.com/modules/dropdown.html");
        WebElement e=driver.findElement(By.xpath("(//div[text()='Gender']/following-sibling::div/div)[1]"));
        String text=e.getText();
        System.out.println(text);
        String y=(String) driver.executeScript("return(arguments[0].textContent);",e);
        System.out.println(y);

    }
}
