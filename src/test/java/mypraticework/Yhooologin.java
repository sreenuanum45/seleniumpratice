package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Yhooologin {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://in.mail.yahoo.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login-username")).sendKeys("sreenuanumandla@yahoo.com");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-passwd")).sendKeys("Veeru80@");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Compose")).click();

		driver.findElement(By.id("message-to-field")).sendKeys("sreenuanumandla45@gmail.com");
		driver.findElement(By.xpath("//input[@aria-label='Subject']")).sendKeys("hi iam send amail to you");
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("hi friend how about you");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='file']/preceding-sibling::button"))
				.sendKeys("C:\\Users\\sreenu\\OneDrive\\Pictures\\Screenshots");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Send this email']")).click();
		Thread.sleep(3000);
		String s2 = driver.findElement(By.xpath("//span[text()='Your ']")).getText();
		System.out.println(s2);

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.fastmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("sreenuanumandla");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("Veeru80@");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Log in']//parent::button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Inbox']]")).click();
		Thread.sleep(3000);
		String s1 = driver.findElement(By.xpath("//span[@title='sreenuanumandla@yahoo.com']")).getText();
		System.out.println(s1);

	}

}
