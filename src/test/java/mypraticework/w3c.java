package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class w3c {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/");
		Thread.sleep(5000);

		// driver.findElement(By.xpath("//a[text()='Try it Yourself'][1]")).click();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");

		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.name("fname")).sendKeys("sreenu");
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys("Anumandla");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().defaultContent();
		driver.close();

	}

}
