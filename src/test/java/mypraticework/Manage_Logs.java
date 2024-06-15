package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

public class Manage_Logs {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.get("https://www.facebook.com/");
		Set<String> s = driver.manage().logs().getAvailableLogTypes();
		System.out.println(s);
		// Get browser logs
		System.out.println("Browser logs:");
		LogEntries bl = driver.manage().logs().get("browser");
		for (LogEntry l : bl) {
			System.out.println(l.getMessage());
		}
		System.out.println("clentlogs");
		LogEntries cl = driver.manage().logs().get("client");
		for (LogEntry l : cl) {
			System.out.println(l.getMessage());
		}
		LogEntries dl = driver.manage().logs().get("driver");
		for (LogEntry l : dl) {
			System.out.println(l.getMessage());
		}
		driver.close();
	}
}
