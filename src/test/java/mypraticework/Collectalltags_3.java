package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Collectalltags_3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		// Collect all <input> tag elements
		List<WebElement> l1 = driver.findElements(By.xpath(
				"//input[@type='text']|(//textarea)|(//div)|(//checkbox)|(//radio)|(//url)|(//week)|(//search)"));

		System.out.println("l1 size:" + l1.size());
		int visible = 0;
		int invisible = 0;
		for (WebElement e : l1) {
			if (e.isDisplayed()) {
				visible++;
			} else {
				invisible++;
			}

		}
		System.out.println(" visible" + visible);
		System.out.println(" invisible" + invisible);

	}
}