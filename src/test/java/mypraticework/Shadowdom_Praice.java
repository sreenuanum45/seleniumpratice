package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Shadowdom_Praice {
	public static void main(String[] args) throws Exception {
		// open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site
		driver.get("chrome://settings/"); // base url
		Thread.sleep(5000);
		// operate an element under nested shadow-root
		 driver.findElement(By.tagName("settings-ui")).getShadowRoot()
		 .findElement(By.id("toolbar")).getShadowRoot()
		  .findElement(By.id("search")).getShadowRoot()
		 .findElement(By.id("searchInput")).sendKeys("abdul kalam");
		driver.findElement(By.tagName("settings-ui")).getShadowRoot().findElement(By.id("toolbar")).getShadowRoot()
				.findElement(By.id("search")).getShadowRoot().findElement(By.id("searchInput")).sendKeys("Sreenu");

	}

}
