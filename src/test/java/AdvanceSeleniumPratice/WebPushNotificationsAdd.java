package AdvanceSeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class WebPushNotificationsAdd {
    @Test
    public void test() {
        /*Map<String,Object>hm=new HashMap<String,Object>();
        hm.put("profile.default_content_setting_values.notifications",1);
        //add more
        ChromeOptions co=new ChromeOptions();
        co.setExperimentalOption("prefs",hm);
        RemoteWebDriver driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com");*/
        //way-1: code bypassing
        //Open browser, launch site and allow web push notifications window
        //Create a map to store  preferences
        Map<String, Object> hm=new HashMap<String, Object>();
        //add key and value to map
        //Pass the argument 1 to "allow" and 2 to "block"
        hm.put("profile.default_content_setting_values.notifications",2);
        //Create an instance of ChromeOptions
        ChromeOptions co=new ChromeOptions();
        // set ExperimentalOption - prefs
        co.setExperimentalOption("prefs",hm);
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("http://www.spicejet.com");


    }
}
