package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Fastmail_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		Thread.sleep(3000);

		driver.get("https://www.fastmail.com/");

		Thread.sleep(5000); // do login
		driver.findElement(By.xpath("//button[@id='menu-btn']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
		Thread.sleep(10000);
		driver.findElement(By.name("username")).sendKeys("sreenuanumandla@fastmail.com");
		driver.findElement(By.name("password")).sendKeys("Veeru80@");
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a.s-new-message")).click();
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("textarea.v-EmailInput-input")).sendKeys("gouthambogoju@gmail.com");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("my fastmailsending");
		driver.findElement(By.xpath("//div[@aria-label='Body']")).sendKeys("hi hello");
		driver.findElement(By.xpath("//span[text()='Attach']/following::*[1]")).click();
		/*
		 * for above xpath //div[@class='v-Compose-section']//span
		 * //span[text()='Attach']/following::*[1]
		 */ Thread.sleep(5000);
		// driver.findElement(By.xpath("//span[text()='Upload files']")).click();
		driver.findElement(By.xpath("//span[text()='Upload files']/preceding-sibling::input"))
				.sendKeys("E:\\sreenuimages\\image14.jpg");
		Thread.sleep(1000);

		// Set the file path to upload
		// String filePath = "E:\\sreenuimages\\image14.jpg";

		// Use the Robot class to handle the file upload dialog
		/*
		 * try { Robot robot = new Robot();
		 *
		 * // Type the file path into the file name field StringSelection selection =
		 * new StringSelection(filePath);
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,
		 * null);
		 *
		 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
		 * robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
		 *
		 * // Press Enter to confirm the file selection
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER); }
		 * catch (AWTException e) { e.printStackTrace(); }
		 */
		driver.findElement(By.xpath("//span[text()='Send']/parent::button[@type='button']")).click();
		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(10000);
		Set<String> s1 = driver.getWindowHandles();
		List<String> l1 = new ArrayList<>(s1);
		driver.switchTo().window(l1.get(1));
		Thread.sleep(10000);

		driver.get("https://www.yahoomail.com");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("login-username")).sendKeys("sreenuanumandla@yahoo.com");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("login-passwd")).sendKeys("Veeru80@");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(10000);

	}

}
