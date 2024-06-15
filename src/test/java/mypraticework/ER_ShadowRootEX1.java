package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ER_ShadowRootEX1 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();// open chrome browser
		driver.get("chrome://settings/");
		Thread.sleep(13000);
		driver.findElement(By.tagName("settings-ui")).getShadowRoot().findElement(By.id("toolbar")).getShadowRoot()
				.findElement(By.id("search")).getShadowRoot().findElement(By.xpath("//input[@id=searchInput]"))
				.sendKeys("wasim");

	}

}
