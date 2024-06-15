package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IframeTest13_shadowroot {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();

		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		driver.switchTo().frame("pact");
		Thread.sleep(5000);
		WebElement shadowhostelement = driver.findElement(By.id("snacktime"));
		SearchContext shadowelement = shadowhostelement.getShadowRoot();
		WebElement targetelement = shadowelement.findElement(By.partialLinkText("Testers Food"));
		try {
			targetelement.click();
			Thread.sleep(5000);
		} catch (JavascriptException e) {
			driver.executeScript("arguments[0].click()", targetelement);
		}
		Set<String> s = driver.getWindowHandles();
		List<String> l1 = new ArrayList<>(s);
		System.out.println(l1);
		driver.switchTo().window(l1.get(1));
		driver.findElement(By.xpath("//li[@id='menu-item-48']/a")).click();
		Thread.sleep(5000);
	}

}
