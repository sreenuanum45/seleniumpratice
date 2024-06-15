package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IframeTest10_shadowroot {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();

		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		Thread.sleep(5000);
		driver.switchTo().frame("pact");

		WebElement ShadowroootHostelement = driver.findElement(By.id("snacktime"));
		SearchContext ShadowrootElemet = ShadowroootHostelement.getShadowRoot();
		WebElement targetElement = ShadowrootElemet.findElement(By.name("chai"));

		try {
			targetElement.click();

			targetElement.sendKeys("sreenu");
		} catch (JavascriptException ex) {
			driver.executeScript("arguments[0].click();", targetElement);
		}

	}

}
