package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IframeTest11_sb1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();

		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		Thread.sleep(5000);
		driver.switchTo().frame("pact");
		driver.findElement(By.id("snacktime")).getShadowRoot().findElement(By.id("app2")).getShadowRoot()
				.findElement(By.id("pizza")).sendKeys("sreenu");

		Thread.sleep(5000);

	}

}
