package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test1 {

	public static void main(String[] args) throws Exception, ClassNotFoundException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://web.whatsapp.com");
		Thread.sleep(2000);
		String x = driver.getTitle();
		System.out.println(x);
		String x1 = driver.getCurrentUrl();
		System.out.println(x1);
		// get the pagesource of the active browser window
		String z = driver.getPageSource();

		driver.close();
	}

}
