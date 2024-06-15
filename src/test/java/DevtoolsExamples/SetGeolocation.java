package DevtoolsExamples;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SetGeolocation {
    @Test
    public void test() {
        //open browser
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //Create DevTools session and set latitude and longitude values of desired location
        DevTools dt=driver.getDevTools();
        dt.createSession();
        HashMap<String,Object> params=new HashMap<String,Object>();
        params.put("latitude",27.1751);
        params.put("longitude",121.0421);
        params.put("accuracy", 1);
        driver.executeCdpCommand("Emulation.setGeolocationOverride",params);
        //Launch site
        driver.get("http://www.google.com");

driver.close();
    }
}
