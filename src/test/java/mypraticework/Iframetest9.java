package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Iframetest9 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.get("https://chercher.tech/practice/frames");
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("sreenu");
		Thread.sleep(5000);
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@type='checkbox']/preceding-sibling::b")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.id("animals")).click();
		// back to page directly
		driver.switchTo().defaultContent();
	}

}
