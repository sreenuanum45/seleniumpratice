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

public class Webelement_GetDomAttribute_DomProperty {
    RemoteWebDriver driver;
    @Test
    public  void method1() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.flipkart.com");

        /*WebElement e= driver.findElement(By.name("q"));
       String s= e.getDomAttribute("type");
       String s1=e.getDomProperty("baseURI");
       System.out.println(s);
       System.out.println(s1);*/
        ////
        /*WebElement e= driver.findElement(By.name("q"));
        String s= e.getDomAttribute("type");
        String s1=e.getDomAttribute("baseURI");//null
        System.out.println(s);
        System.out.println(s1);*/
        WebElement e= driver.findElement(By.name("q"));
        String s= e.getDomProperty("type");
        String s1=e.getDomProperty("baseURI");
       /* System.out.println(s);//text
        System.out.println(s1);//https://www.flipkart.com/*/
       driver.executeScript("console.dir(arguments[0]);",e);
       // Retrieve browser console logs
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);

        // Iterate through logs to find console messages
        for (LogEntry entry : logs) {
            if (entry.getMessage().contains("CONSOLE")) {
                System.out.println("Console Output: " + entry.getMessage());
            }
        }
        //Close site


    }
    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Thread.sleep(3000);
        driver.manage().window().maximize();

    }
}
