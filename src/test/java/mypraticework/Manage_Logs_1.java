package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Manage_Logs_1  {
    RemoteWebDriver driver;
    @BeforeTest
    public  void setup(){
        WebDriverManager.chromedriver().driverVersion("5.1.0").setup();
         driver = new ChromeDriver();
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
    @Test
    public  void  youtube ()
    {
        driver.get("https://www.youtube.com/");
        Set<String>logTypes=driver.manage().logs().getAvailableLogTypes();
        System.out.println(logTypes);
        System.out.println("browser logs:");
        LogEntries le=driver.manage().logs().get("browser");
        for(LogEntry l:le)
        {
            System.out.println(l.getMessage());
        }
        System.out.println("driver logs:");
        LogEntries l1=driver.manage().logs().get("driver");
        for(LogEntry lx:l1)
        {
            System.out.println(lx.getMessage());
        }
        System.out.println("Client logs:");
        LogEntries l3=driver.manage().logs().get("Client");
        for(LogEntry ly:l3)
        {
            System.out.println(ly.getMessage());
        }
    }

}
