package DevtoolsExamples;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

public class RecovryTest {
    public ChromeDriver driver ;
    public DevTools dt;
    @Test
    public void test() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        dt=driver.getDevTools();
        dt.createSession();
        Thread.sleep(5000);

        try{
            Command cd=new Command<>("Browser.crash", ImmutableMap.of());
            dt.send(cd);
        }catch (Exception e){
            System.out.println("continue further testing");
        }
        Thread.sleep(5000);
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.amazon.com");
            System.out.println("recovery test passed");
         driver.close();
        }catch (Exception e){
            System.out.println("recovery test failed");
        }
    }
}
