package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CookiesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Cookie_2 {
    CookiesUtility cu;
    RemoteWebDriver driver;
    @Test(priority = 1)
    public  void  amazonCookiesTest1(){
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
         cu=new CookiesUtility();

        System.out.println(cu.getCookiesCount(driver));
        // System.out.println(cu.getCookiesList(driver));
        List<String> cookies=cu.getCookiesList(driver);
        for(String c:cookies){

            System.out.println(c);
        }
        //get cookies type
        System.out.println("@=============*");
        List <String> cookiesTypes= cu.getTypeofCookies(driver,"https://www.amazon.in","https://www.amazon.com");
        for(String c:cookiesTypes){

            System.out.println(c);
        }
    }
    @Test(priority = 2)
    public  void  amazonCookiesTest2(){
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphones");
        System.out.println("after Searching the word");
        cu=new CookiesUtility();

        System.out.println(cu.getCookiesCount(driver));
        // System.out.println(cu.getCookiesList(driver));
        List<String> cookies=cu.getCookiesList(driver);
        for(String c:cookies){

            System.out.println(c);
        }
        //get cookies type
        System.out.println("@=============*");
        List <String> cookiesTypes= cu.getTypeofCookies(driver,"https://www.amazon.in","https://www.amazon.com");
        for(String c:cookiesTypes){

            System.out.println(c);
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