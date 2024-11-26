package mypraticework;

import mypractice_utility.CookiesUtility;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ManageMethodPractice_1 {
    @Test
    public void test() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.naukri.com/nlogin/login?URL=https://www.naukri.com/mnjuser/homepage");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));
        driver.manage().addCookie(new Cookie("naukri", "sreenu"));
        Set<String> l = driver.manage().logs().getAvailableLogTypes();
        List<String> list = new ArrayList<>(l);
        for (String s : list) {
            LogEntries logEntries = driver.manage().logs().get(s);
            for (LogEntry logEntry : logEntries) {
                System.out.println(logEntry.getMessage()+"  "+logEntry.getTimestamp());
            }
            System.out.println("==========");
        }
       Set<Cookie>ss= driver.manage().getCookies();


        List<Cookie>l1=new ArrayList<>(ss);
        System.out.println(l1.size());
        for(Cookie cookie:l1){
            System.out.println(cookie.getName()+""+cookie.getDomain()+"  "+cookie.getExpiry());
        }
        CookiesUtility cu = new CookiesUtility();
        cu.DeleteCookiesViaName(driver,"MYNAUKBMS[resolution]");
        for(Cookie cookie:l1){
            System.out.println(cookie.getName()+"  "+cookie.getDomain()+"  "+cookie.getExpiry());
            if(cookie.isHttpOnly()){
                System.out.println(cookie.getName()+"is http only cookie");
            }
            else if(cookie.isSecure()){
                if(cookie.getExpiry()!=null && cookie.getName().equalsIgnoreCase("session id-time")){
                    System.out.println(cookie.getName()+"is secure and persistance cookie");
                }
                else if(cookie.getName().equalsIgnoreCase("session id")){
                    System.out.println(cookie.getName()+"is session cookie");
                }
                }
            }
        Date expiryDate=new Date();
        String sameSite="Lax";
        expiryDate.setYear(expiryDate.getYear()+1);
        expiryDate.setMonth(expiryDate.getMonth()+1);
        expiryDate.setDate(expiryDate.getDate()+1);
        cu.addNewCookie(driver,"session id",""+Math.random()+"M","www.naukri.com","/",expiryDate,true,true,sameSite);
        //cu.addNewCookieViaBuilder(driver,"session id","12345","www.naukri.com","chrome://whats-new/",expiryDate,true,false,sameSite);
        System.out.println(cu.getCookiesCount(driver));
        cu.DeleteCookies(driver);
        if(l1.size()==0){
            System.out.println("cookies are deleted");
        }
        else{
            System.out.println("cookies are not deleted");
        }
        System.out.println(cu.getCookiesCount(driver));
    }

    }

