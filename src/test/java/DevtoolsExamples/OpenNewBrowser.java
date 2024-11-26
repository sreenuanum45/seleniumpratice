package DevtoolsExamples;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Map;

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
