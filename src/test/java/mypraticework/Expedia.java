package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Expedia {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.expedia.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//li[@role='presentation'][2]//a/span[text()='Flights']")).click();
		Thread.sleep(2000);
		WebElement ee = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		ee.click();
		Thread.sleep(2000);

		WebElement e = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		driver.executeScript("arguments[0].value='Hyderabad';", e);

		e.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='Going to']")).click();
		Thread.sleep(2000);
		WebElement ee1 = driver.findElement(By.xpath("//input[@placeholder='Going to']"));
		ee1.click();
		ee1.sendKeys("Mumbai");
		ee1.sendKeys(Keys.ENTER);
		WebElement ee2 = driver.findElement(By.xpath("(//button[@type='button'])[10]"));
		ee2.click();

	}

}
