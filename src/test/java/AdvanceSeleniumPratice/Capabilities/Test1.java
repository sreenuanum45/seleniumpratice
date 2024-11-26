package AdvanceSeleniumPratice.Capabilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test1 {
    @Test
    public void test1() throws IOException {
        int debuggingport=9222;
        ChromeOptions options = new ChromeOptions();
      //  options.setExperimentalOption("debuggerAddress", "127.0.0.1:"+debuggingport);
        options.setCapability("debuggerAddress", "127.0.0.1:"+debuggingport);
        ChromeDriverService chromeDriverService = new ChromeDriverService.Builder().usingAnyFreePort().build();
        chromeDriverService.start();
        ChromeDriver driver = new ChromeDriver(chromeDriverService, options);
        driver.get("http://www.google.co.in");

    }
}
