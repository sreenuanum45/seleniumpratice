package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
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

		WebElement ShadowroootHostelement = driver.findElement(By.xpath("//div[@class='jackPart']"));
		SearchContext ShadowrootElemet = ShadowroootHostelement.getShadowRoot();
		WebElement targetElement = ShadowrootElemet.findElement(By.name("chai"));
driver.switchTo().newWindow(WindowType.WINDOW);
		try {
			targetElement.click();

			targetElement.sendKeys("sreenu");
		} catch (JavascriptException ex) {
			driver.executeScript("arguments[0].click();", targetElement);
		}

	}

}
