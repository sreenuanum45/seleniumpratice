package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Iframetest3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("Background")).click();
		// driver.findElement(By.xpath("//a[normalize-space()='Beginners
		// Guide'])/parent::span[1]")).click();
		// driver.findElement(By.xpath("(//a[normalize-space()='Beginners
		// Guide'])//following::*[1]")).click();
		Thread.sleep(12000);
		// driver.findElement(By.xpath("//a[text()='Beginners Guide']")).click();
		// driver.findElement(By.xpath("//a[normalize-space()='Beginners
		// Guide']")).click();
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		Thread.sleep(4000);
		// driver.findElement(By.name("name")).sendKeys("srenu").click();
		WebElement s1 = driver.findElement(By.xpath("//input[@type='text']"));
		s1.click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sreenu");
		// driver.findElement(By.xpath("//input[@type='text']//parent::td")).sendKeys("Srenu");
		WebElement s2 = driver.findElement(By.name("suggestions"));
		s2.click();
		driver.findElement(By.name("suggestions")).sendKeys("Anumandlasreenu");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		driver.switchTo().frame(3);
		Thread.sleep(4000);
		// (//a[normalize-space()='TRY CODING'])[1]
		driver.findElement(By.linkText("TRY CODING")).click();

	}
}
