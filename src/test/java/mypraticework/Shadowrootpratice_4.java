package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Shadowrootpratice_4 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		driver.switchTo().frame("pact");
		Thread.sleep(10000);

		WebElement hostElement = driver.findElement(By.id("snacktime"));
		WebElement targetElement = (WebElement) driver
				.executeScript("return arguments[0].shadowRoot.querySelector('#tea')", hostElement);

		try {
			targetElement.sendKeys("Hi");
		} catch (JavascriptException ex) {
			driver.executeScript("arguments[0].value='Hi';", targetElement);
		}

	}
}
