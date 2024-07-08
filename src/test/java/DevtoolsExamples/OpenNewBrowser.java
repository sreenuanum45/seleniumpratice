package DevtoolsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.Map;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.c;

public class OpenNewBrowser {

    @Test
    public void test() throws InterruptedException {
        //Open browser

        ChromeDriver driver=new ChromeDriver();

//get browser capabilities in key value pairs
 Capabilities c=driver.getCapabilities();

        Map<String, Object> m=c.asMap();

        m.forEach((key, value) ->

        { System.out.println("Key is: "+ key+" Value is: "+ value);

        });
        driver.get("https://www.facebook.com");
        Thread.sleep(5000);



    }
}
