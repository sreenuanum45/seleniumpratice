package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Navigate_Method_pratice {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.mercurytravels.co.in");
		Thread.sleep(4000);
		URL url = new URL("https://www.youtube.com");
		Thread.sleep(4000);
		driver.navigate().to(url);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().forward();
		Thread.sleep(4000);
		driver.navigate().to("https://www.google.co.in");
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		// close site
		// driver.close();

	}
}
