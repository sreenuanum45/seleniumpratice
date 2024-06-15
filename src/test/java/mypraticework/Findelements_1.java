package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Findelements_1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();

		driver.get("https://www.youtube.com/");
		Thread.sleep(8000);
		driver.manage().window().maximize();

		List<WebElement> l1 = driver.findElements(By.tagName("//a"));
		System.out.println("all elments count:" + l1.size());
		int visuble = 0;
		int invisible = 0;
		for (WebElement e : l1) {
			Thread.sleep(20000);
			if (e.isDisplayed()) {
				visuble = visuble + 1;
				driver.executeScript("arguments[0].style.border='3px solid pink';", e);
			} else {
				invisible = invisible + 1;
			}
		}
		System.out.println(" visuble count:" + visuble);
		System.out.println(" invisuble (hidden)count:" + invisible);
		// driver.close();
	}

}
