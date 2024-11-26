package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CookiesUtility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Cookie_1 {
    RemoteWebDriver driver;
    @Test
    public  void  amazonCookiesTest(){
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        CookiesUtility cu=new CookiesUtility();
        System.out.println("count of cookies:"+cu.getCookiesCount(driver));
      System.out.println("cookies list:"+cu.getCookiesList(driver));

        List <String> cookies=cu.getCookiesList(driver);
        for(String c:cookies){
            System.out.println(c);
        }
        //get cookies type
        System.out.println("@=============*");
        List <String> cookiesTypes= cu.getTypeofCookies(driver,"https://www.amazon.in","https://www.amazon.com");
        for(String c:cookiesTypes){
            System.out.println("type of cookies:"+c);
        }

    }
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
}
