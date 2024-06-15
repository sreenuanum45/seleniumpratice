package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class Manage_Timeouts_2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Duration d = driver.manage().timeouts().getPageLoadTimeout();
		System.out.println(d.getSeconds());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(1835));
		driver.get("https://www.gmail.com");
		// close site
		driver.close();
	}
}
