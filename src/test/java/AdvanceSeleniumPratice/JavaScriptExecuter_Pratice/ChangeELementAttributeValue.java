package AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChangeELementAttributeValue {
    @Test
    public void method() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        driver.get("https://www.facebook.com/login/");
        WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.executeScript("arguments[0].setAttribute('name','gmail')",username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("gmail"))).sendKeys("7416472820", Keys.TAB);
        System.out.println(username.getAttribute("name"));
        WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        driver.executeScript("arguments[0].disabled=true;",password);

        driver.executeScript("arguments[0].remove('placeholder')",username);
       // System.out.println(username.getAttribute("placeholder"));
        WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbutton")));
        driver.executeScript(
                "var para=document.createElement('p');"
                        +"var tn=document.createTextNode('hi sreenu');"
                        + "para.appendChild(tn); "
                        + "arguments[0].appendChild(para);",login);
        System.out.println(login.getText());
    }

}
