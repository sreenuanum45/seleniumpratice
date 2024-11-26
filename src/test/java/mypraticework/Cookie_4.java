package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CookiesUtility;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Cookie_4 {
    CookiesUtility cu;
    RemoteWebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.timesofindia.com");
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
    @Test
    public void TimesOfIndia(){
        cu=new CookiesUtility();
       driver.manage().addCookie(new Cookie("timesofindia","Sreenu"));
        System.out.println(cu.getCookiesCount(driver));
        System.out.println(cu.getCookiesList(driver));
       List<String>types= cu.getTypeofCookies(driver,"timesofindia.com","indiatimes.com");
       for( String type:types){
           System.out.println(type);
       }
    }
}
