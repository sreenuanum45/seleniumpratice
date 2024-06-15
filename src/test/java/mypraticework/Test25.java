package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test25 {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site
		driver.get("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");
		Thread.sleep(5000);
		// Click on "Background" link
		driver.switchTo().frame(0);
		driver.findElement(By.partialLinkText("Background")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		// Click on Close button
		driver.switchTo().frame(1);
		driver.findElement(By.name("update")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		// Click on "TRY CODING" link
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("(//a[normalize-space()='TRY CODING'])[1]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

	}

}
