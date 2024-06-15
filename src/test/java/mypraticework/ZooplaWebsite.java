package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ZooplaWebsite {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().window().maximize();
		Thread.sleep(9000);
		WebElement e = driver.findElement(By.tagName("input"));
		e.sendKeys("London");
		Thread.sleep(9000);
		e.sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//div[text()='Search']")).click();
		Thread.sleep(9000);
		try {
			WebElement iframeElement = driver.findElement(By.xpath("//iframe[@allow='cross-origin-isolated']"));
			Thread.sleep(9000);
			// Switch to the iframe
			driver.switchTo().frame(iframeElement);
			Thread.sleep(9000);
			WebElement e1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
			e1.click();
			Thread.sleep(9000);
			e1.click();
		} catch (Exception e2) {
			// TODO: handle exception
		}

		/*
		 * driver.findElement(By.xpath("//span[text()='Any price']/parent::button")).
		 * click();
		 * driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		 */
	}

}
