package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Fblogin {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		RemoteWebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.get("https://www.facebook.com");
		FluentWait<RemoteWebDriver>wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//driver.findElement(By.id("email")).sendKeys("8919188076");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("8919188076");
		//driver.findElement(By.id("pass")).sendKeys("naveen80");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass"))).sendKeys("naveen80");
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();


	}

}
