package DevtoolsExamples;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HandlingSSl {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        options.setAcceptInsecureCerts(true);
    }
}
