package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CookiesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Cookie_3 {
    CookiesUtility cu;
    CookiesUtility cu1;
    RemoteWebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        }
        @Test
    public void YahooLoginTest()throws Exception{
            driver.get("https://login.yahoo.com");
            driver.manage().window().maximize();
            Thread.sleep(1000);
            driver.findElement(By.id("login-username")).sendKeys("sreenuanumandla@yahoo.com");
            driver.findElement(By.id("login-signin")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("login-passwd")).sendKeys("Veeru80@");
            driver.findElement(By.id("login-signin")).click();
            Thread.sleep(1000);
            System.out.println("cookies after login  to site");
            cu=new CookiesUtility();
            System.out.println(cu.getCookiesCount(driver));
            System.out.println(cu.getCookiesList(driver));
            List<String> cookies=cu.getCookiesList(driver);
            for(String c:cookies){

                System.out.println(c);
            }
            //get cookies type
            System.out.println("@=============*");
            List <String> cookiesTypes= cu.getTypeofCookies(driver,"yahoomail.com","yahoo.com");
            for(String c:cookiesTypes){

                System.out.println(c);
            }
            driver.findElement(By.id("ybarAccountMenu")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("profile-signout-link")).click();
            //do logout
            System.out.println("logout cookies");
            cu1=new CookiesUtility();
            System.out.println(cu1.getCookiesCount(driver));
            System.out.println(cu1.getCookiesList(driver));
            List<String> cookies2=cu1.getCookiesList(driver);
            for(String c:cookies2){

                System.out.println(c);
            }
            //get cookies type
            System.out.println("@=============*");
            List <String> cookiesTypes2= cu.getTypeofCookies(driver,"yahoo.mail.com","yahoo.com");
            for(String c:cookiesTypes){

                System.out.println(c);
            }
        }

        }

