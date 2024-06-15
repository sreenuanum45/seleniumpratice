package mypractice_utility.AdvanceSeleniumPratice.Capabilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

public class GetBrowserCapabilities {
    @Test
    public void test() {
        //Open browser
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://www.google.co.in");
        Capabilities c=driver.getCapabilities();
 System.out.println(c.getBrowserVersion());
        System.out.println(c.getBrowserName());
       System.out.println( c.getPlatformName().getMajorVersion());
        c.getCapability("log.txt");

        Map<String,Object> m=c.asMap();


        m.forEach((key, value) ->
        {
            System.out.println("Key is: " + key + " Value is: " + value);
        });
        //don't close browser
        //copy "localhost:50839" like value in output
        //Then goto next program
    }
}
