package DevtoolsExamples;

import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import javax.sound.sampled.Port;
import java.io.IOException;

public class AccessingExistingBrowser_1 {

    @Test
    public void test() {


        String debuggingPort = "61455";

        // Initialize ChromeOptions and set the debugger address
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=" + debuggingPort);

        // Initialize ChromeDriverService
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();

        try {
            // Start the ChromeDriverService
            service.start();

            // Initialize ChromeDriver with the service and options
            ChromeDriver driver = new ChromeDriver(service, options);

            // Interact with the existing browser session
            driver.get("https://www.google.com");
            System.out.println("Title: " + driver.getTitle());

            // Close the browser
            driver.quit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Stop the service
            service.stop();
        }
    }

}
