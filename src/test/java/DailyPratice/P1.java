package DailyPratice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class P1 {
    public static void main(String[] args) {
        RemoteWebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        System.out.println(driver);
        driver.close();
        System.out.println(driver);
        driver.quit();
        System.out.println(driver);
        driver.get("https://www.facebook.com");
    }
}
