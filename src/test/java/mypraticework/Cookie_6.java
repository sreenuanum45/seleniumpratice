package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CookiesUtility;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Cookie_6 {
    List<String>cl;
    CookiesUtility cu;
    RemoteWebDriver driver;
    List<String>tc;
    Date today=new Date();
    @Test(priority = 1)
    public void AmazonTest1()   {
       String name="session-id";
       String value="12345";
       String domain="www.amazon.in";
       String path="/";
       Date expiryDate=new Date(today.getTime()+3000);
       boolean isSecure=true;
       boolean isHttpOnly=false;
       String sameSite="Lax";
        cu=new CookiesUtility();
        cu.addNewCookie(driver,name,value,domain,path,expiryDate,isSecure,isHttpOnly,sameSite);

    }
    @Test(priority = 2)
    public void AmazonTest2(){
        cu=new CookiesUtility();
       System.out.println("Cookies count:"+cu.getCookiesCount(driver));
       System.out.println("list of cookies:");
       System.out.println("CookiesList:"+cu.getCookiesList(driver));
        cl= cu.getCookiesList(driver);
     for(String cc:cl){
         System.out.println(cc);
     }
     tc=cu.getTypeofCookies(driver,"https://www.amazon.in","https://www.amazon.com");
     System.out.println("types of cookies");
        for(String TypeCookie:tc){
            System.out.println(TypeCookie);
        }

    }
    @Test(priority = 3)
    public void AmazonTest3(){

       Cookie c =driver.manage().getCookieNamed("session-id");
       System.out.println(c.getName()+"      "+c.getDomain()+"    "+c.getValue());
     Set<Cookie> s=driver.manage().getCookies();
     List<Cookie>l=new ArrayList<>(s);
     driver.manage().deleteCookie(l.get(2));//delete specific only
        driver.manage().deleteCookieNamed("session-id");//delect specific named cookies
        cu=new CookiesUtility();
     cu.DeleteCookies(driver);
     driver.close();
    }
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
    }

}
