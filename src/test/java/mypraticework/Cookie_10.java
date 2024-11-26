package mypraticework;

import mypractice_utility.CookiesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Cookie_10 {
    RemoteWebDriver driver;
    RemoteWebDriver driver1;
    @Test
    public void method1() throws InterruptedException {
        driver=new ChromeDriver();
        driver1=new ChromeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        WebElement e=driver.findElement(By.name("q"));
        e.sendKeys("iphone");
        e.submit();
        CookiesUtility cu=new CookiesUtility();
        Set<Cookie>s=driver.manage().getCookies();
        List<Cookie>ls=new ArrayList<>(s);
        for(Cookie c:ls){
            System.out.println(c.getName()+"  "+c.getValue());
            try{
                String name="session-id";
                String value="12345";
                String domain="https://www.flipkart.com";
                String path="/";
                Date expiryDate=null;
                boolean isSecure=true;
                boolean isHttpOnly=false;
                String sameSite="Lax";
                cu.addNewCookie(driver,name,value,domain,path,expiryDate,isSecure,isHttpOnly,sameSite);
                cu.DeleteCookies(driver);
                driver.manage().deleteAllCookies();
            }catch (Exception e1){
                e1.getMessage();

            }
            driver1.navigate().to("https://www.flipkart.com");
            Thread.sleep(2000);
            if(driver.getCurrentUrl().contains("https"))
            {

            }
        }





    }
}
