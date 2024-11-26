package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CookiesUtility;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class Cookie_7 {
    CookiesUtility cu;
    RemoteWebDriver driver;
    List<Cookie>l;
    @BeforeTest
    public void method1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
        Thread.sleep(1000);
    }
    @Test(priority=1)
    public void method2(){
        cu=new CookiesUtility();
        Date today=new Date();
        Date tommorow=new Date(today.getTime()+3000);
        cu.addNewCookieViaBuilder(driver,"session-id-time","7416472820","www.youtube.com","/",tommorow,true,false,"Lax");

    }
    @Test(priority=2)
    public void  method3() throws InterruptedException {
        cu=new CookiesUtility();
        List<String>l1=cu.getCookiesList(driver);
        for(String ll:l1){
            System.out.println(ll);
        }
        Thread.sleep(5000);
        List<String>l2=cu.getCookiesList(driver);
        for(String ll:l2){
            System.out.println(ll);
        }
    }
    @Test(priority=3)
    public void methoid4() throws Exception
    {
        //Close site
        driver.close();
    }
}
