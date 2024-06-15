package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Findelements_4 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch google
		driver.get("https://www.youtube.com/");
		Thread.sleep(5000);
		List<WebElement> l = driver.findElements(By.tagName("//a"));
		System.out.println("All elements count is " + l.size());
		int vec = 0;
		int iec = 0;
		for (WebElement e : l) {
			if (e.isDisplayed()) {
				vec = vec + 1;
				driver.executeScript("arguments[0].style.border='2px dotted orange';", e);
			} else {
				iec = iec + 1;
			}

		}
		System.out.println(vec);
		System.out.println(iec);

	}

}
