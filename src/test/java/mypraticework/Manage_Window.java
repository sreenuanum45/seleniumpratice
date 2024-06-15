package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Manage_Window {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.navigate().to("https://www.mercurytravels.co.in");

		// Wait for the page to load
		wait.until(ExpectedConditions.titleContains("Mercury Travels"));

		// Get the current window size and print it
		// Use fully qualified name for selenium Dimension
		org.openqa.selenium.Dimension currentSize = driver.manage().window().getSize();
		System.out.println("Current size: " + currentSize.getWidth() + " x " + currentSize.getHeight());

		// Set a new window size using the Dimension class
		org.openqa.selenium.Dimension newSize = new org.openqa.selenium.Dimension(1200, 1000);
		driver.manage().window().setSize(newSize);

		// Get the current window position and print it
		// Use fully qualified name for selenium Point
		org.openqa.selenium.Point currentPosition = driver.manage().window().getPosition();
		System.out.println("Current position: " + currentPosition.getX() + ", " + currentPosition.getY());

		// Move the window to a new position using the Point class
		org.openqa.selenium.Point newPosition = new org.openqa.selenium.Point(100, 200);
		driver.manage().window().setPosition(newPosition);

		// Enter fullscreen mode
		driver.manage().window().fullscreen();

		// Wait for fullscreen mode to be applied
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

		// Simulate pressing the "ESC" key using the Robot class to exit fullscreen mode
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		// Wait for the window to exit fullscreen mode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

		// Close the browser
		driver.quit();
	}
}
