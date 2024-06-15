package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class gmailtest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com");
		driver.findElement(By.name("identifier")).sendKeys("anumandlasreenu4545@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//div[text()=\"Couldn’t find your Google
		// Account\"]/following::*")) ;
		driver.findElement(By.xpath("//div[text()=\"Couldn’t find your Google Account\"]/following::div[1]"));
	}

}
