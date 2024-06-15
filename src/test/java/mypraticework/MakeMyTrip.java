package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("fromCity")).click();
		WebElement e = driver.findElement(By.xpath("//input[@placeholder='From']"));
		e.sendKeys("Hyderabad");
		// .findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
		driver.findElement(By.xpath("((//p[text()='Hyderabad, India'])[1])/parent::div")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("toCity")).click();
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.xpath("//input[@placeholder='To']"));
		e1.sendKeys("Mumbai");
		driver.findElement(By.xpath("((//p[text()='Mumbai, India'])[1])/parent::div")).click();
		Thread.sleep(3000);
		int ExceptedYear = 2023;
		String Exceptedmonth = "july";
		int day = 5;

		WebElement dp = driver.findElement(By.id("departure"));
		driver.executeScript("arguments[0].scrollintoview", dp);
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click()", dp);

		while (true) {
			String temp = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
			String[] temper = temp.split(" ");
			int currentyear;
			String currentmonth;
			currentmonth = temper[0];
			currentyear = Integer.parseInt(temper[1]);

			if (ExceptedYear > currentyear) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				Thread.sleep(3000);
			} else if (ExceptedYear < currentyear) {
				driver.findElement(By.xpath("(//span[@role='button'])[1]")).click();
				Thread.sleep(3000);
			}

			else {
				break;
			}

		}
	}
}
