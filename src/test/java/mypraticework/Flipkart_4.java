package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Flipkart_4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// open site
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

		try {
			driver.findElement(By.xpath("//span[text()='Login']/preceding::button[1]")).click();
			Thread.sleep(2000);
		} catch (Exception e) {

			System.out.println("no banner show this time");
		}

		WebElement ee = driver.findElement(By.xpath("(//a/img[@alt='Sign in'])|//a[text()='Login']"));
		try {
			driver.executeScript("arguments[0].click()", ee);
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(4000);
		WebElement e = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		e.click();
		Thread.sleep(3000);
		e.sendKeys("7981651426");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[normalize-space()='Request OTP']")).click();
		Thread.sleep(6000);
		WebElement shadowroothostelement = driver.findElement(By.xpath("//div[@role='region']"));
		WebElement shadowRoot = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].shadowRoot", shadowroothostelement);
		// Switch to the iframe
		driver.switchTo().frame(3);
		WebElement elementToPressAndHold = shadowRoot.findElement(By.xpath("(//div[@role='button']")); // Replace with
																										// your target
																										// element

	}

}
