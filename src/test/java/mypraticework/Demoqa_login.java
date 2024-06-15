package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Demoqa_login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.id("firstName")).sendKeys("sreenu");
		driver.findElement(By.id("lastName")).sendKeys("anumandla");
		driver.findElement(By.id("userEmail")).sendKeys("sreenuanumandla45@gmail.com");
		driver.findElement(By.name("gender")).click();

	}

}
