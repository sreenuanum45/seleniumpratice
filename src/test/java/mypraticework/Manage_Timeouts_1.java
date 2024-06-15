package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class Manage_Timeouts_1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		// define implicit wait at top of the automation code for waiting if required
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.name("fname")).clear();
		driver.findElement(By.name("fname")).sendKeys("sreenu");
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys("anumandla ");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(4000);
		driver.close();
	}
}
