package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IframeTest11_sb {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();

		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		Thread.sleep(5000);
		driver.switchTo().frame("pact");

		WebElement shadowhostelement = driver.findElement(By.id("snacktime"));
		SearchContext ShadowrootElemetouter = (WebElement) shadowhostelement.getShadowRoot();

		WebElement shadowhostelement2 = ShadowrootElemetouter.findElement(By.id("app2"));
		SearchContext ShadowrootElemetinner = (WebElement) shadowhostelement2.getShadowRoot();
		WebElement targetelementinner = ShadowrootElemetinner.findElement(By.id("pizza"));
		try {
			targetelementinner.click();
			targetelementinner.sendKeys("i love biryani at lunch time");
		} catch (JavascriptException e) {
			driver.executeScript("arguments[0].click()", targetelementinner);
		}

	}

}
