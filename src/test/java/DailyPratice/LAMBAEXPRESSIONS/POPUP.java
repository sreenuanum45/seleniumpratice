package DailyPratice.LAMBAEXPRESSIONS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class POPUP {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver=new ChromeDriver();
        Thread.sleep(5000);
        driver.get("https://www.javatpoint.com/oprweb/test.jsp?filename=javascript-alert2");
        driver.getWindowHandles().stream().map((handle)->driver.switchTo().window(handle).getTitle()).filter((title)->title.contains("")).findFirst().orElseThrow(()->new RuntimeException("no such window"));
    }
}
