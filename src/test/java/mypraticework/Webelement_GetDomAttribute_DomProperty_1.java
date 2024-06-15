package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Webelement_GetDomAttribute_DomProperty_1 {
    RemoteWebDriver driver;
    @Test
    public  void method1() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.google.com/");
        WebElement e = driver.findElement(By.name("q"));
        String s = e.getDomProperty("localName");
        System.out.println(s);

        String s1 = e.getDomProperty("ariaLabel");
        System.out.println(s1);
        System.out.println(e.getAttribute("maxlength")); //HTML attribute
        System.out.println(e.getAttribute("clientHeight")); //HTML property
        System.out.println(e.getDomAttribute("maxlength"));
        System.out.println(e.getDomProperty("clientHeight"));
        driver.executeScript("console.dir(arguments[0])", e);
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logs) {
            if (entry.getMessage().contains("Console")) {
                System.out.println(entry.getMessage());
            }
        }
    }
    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
