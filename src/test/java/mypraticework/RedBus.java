package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RedBus {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement e = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		e.sendKeys("warangal");

		WebElement e1 = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		e1.sendKeys("hyderabad");
		driver.findElement(By.xpath("(//div[@role='button'])[3]")).click();
		Thread.sleep(3000);
		// Find the date input field and enter the date
		WebElement dateInput = driver.findElement(By.id("onward_cal"));
		dateInput.sendKeys("7");

		// Find the search button and click on it
		WebElement searchButton = driver.findElement(By.id("search_btn"));
		searchButton.click();
		Thread.sleep(3000);

	}

}
