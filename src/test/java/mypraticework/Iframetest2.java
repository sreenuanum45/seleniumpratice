package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Iframetest2 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		Thread.sleep(4000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.name("fname")).sendKeys("naveen");

		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

}
