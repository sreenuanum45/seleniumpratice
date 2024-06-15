package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Get_method_Checking {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		long st = System.currentTimeMillis();
		driver.get("https://www.mercurytravels.co.in");
		long et = System.currentTimeMillis();
		System.out.println(et - st);

	}
}
