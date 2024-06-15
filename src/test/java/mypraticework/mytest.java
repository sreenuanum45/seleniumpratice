package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.Set;

public class mytest {
	public static void main(String[] args) throws Exception {
		// Setup ChromeDriver
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();

		// Navigate to W3Schools
		driver.get("https://www.w3schools.com");
		Thread.sleep(2000);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Get and print the current URL
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		// Get and print the page source
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);

		// Get and print the title of the page
		String title = driver.getTitle();
		System.out.println(title);

		// Click on the "Try it Yourself" link
		driver.findElement(By.linkText("Try it Yourself")).click();

		// Get and print the window handle
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);

		// Wait for 2 seconds
		Thread.sleep(2000);

		// Get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);

		// Convert the set of window handles to a list
		ArrayList<String> windowList = new ArrayList<>(windowHandles);
		System.out.println(windowList);

		// Switch to the new window
		driver.switchTo().window(windowList.get(1));

		// Click on the "tryhome" button
		driver.findElement(By.id("tryhome")).click();



		// Fullscreen the window
		driver.manage().window().fullscreen();

		// Close the current window
		driver.close();
	}
}
