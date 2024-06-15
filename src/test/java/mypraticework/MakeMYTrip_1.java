package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MakeMYTrip_1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[text()='Hyderabad, India']/parent::div")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("toCity")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[text()='Bengaluru International Airport']/parent::div")).click();
		Thread.sleep(5000);
		WebElement dt = driver.findElement(By.xpath("//label[@for='departure']"));
		dt.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@aria-label='Thu Jul 13 2023']//p[contains(text(),'13')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[normalize-space()='Search'])[1]")).click();
		try {
			driver.findElement(By.xpath("(//button[normalize-space()='OKAY, GOT IT!'])[1]\"")).click();
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println("no banner this time");
		}

		Thread.sleep(5000);

	}
}
