package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FacebookLogin_activeElement {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// open site
		driver.get("https://www.facebook.com/login.php");
		driver.switchTo().activeElement().sendKeys("7416472820", Keys.TAB);
		Thread.sleep(3000);
		driver.switchTo().activeElement().sendKeys("Sreenu45@", Keys.TAB, Keys.TAB);
		Thread.sleep(3000);
		driver.switchTo().activeElement().click();
		driver.switchTo().newWindow(WindowType.TAB);
	}

}
