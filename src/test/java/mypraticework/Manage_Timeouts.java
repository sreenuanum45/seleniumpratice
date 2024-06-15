package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Manage_Timeouts {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(4000);
		// driver.navigate().to("https://www.mercurytravels.co.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.mercurytravels.co.in");

		Select dropdown = new Select(driver.findElement(By.name("nights")));
		dropdown.selectByIndex(3);
		dropdown = new Select(driver.findElement(By.name("theme")));
		dropdown.selectByIndex(1);

	}
}
