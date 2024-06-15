package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Manage_Timeouts_3 {
	public static void main(String[] args) {
		// Setup WebDriver and maximize window
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Initialize WebDriverWait with a timeout of 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Navigate to Gmail
		driver.navigate().to("https://www.gmail.com");

		// Find the element
		WebElement e = driver.findElement(By.name("identifier"));

		// Cast WebDriver to JavascriptExecutor
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Apply a style to the element using executeScript
		jsExecutor.executeScript("arguments[0].style.border='5px blue solid'", e);

		// Wait for the element to be visible using explicit wait
		wait.until(ExpectedConditions.visibilityOf(e));

		// Close the browser
		driver.quit();
	}
}
