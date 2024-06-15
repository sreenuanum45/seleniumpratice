package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Mytest11 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://in.mail.yahoo.com/");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("login-username")).sendKeys("sreenuanumandla@yahoo.com");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("login-passwd")).sendKeys("Veeru80@");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Compose")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("message-to-field")).sendKeys("sreenuanumandla@fastmail.com");
		driver.findElement(By.xpath("//input[@aria-label='Subject']")).sendKeys("test case");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("hi friends, \nhow about you");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='file']"))
				.sendKeys("C:\\Users\\sreenu\\OneDrive\\Pictures\\Screenshots\\Screenshot 2023-05-25 084228.png");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Send this email']")).click();
		Thread.sleep(3000);
		String x = driver.findElement(By.xpath("//div[@role='presentation']/following-sibling::div[1]")).getText();
		System.out.println(x);
		// take new window/tab
		Thread.sleep(5000);
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> s = driver.getWindowHandles();
		List<String> a = new ArrayList<>(s);
		// switch to new window
		driver.switchTo().window(a.get(1));
		// Launch fast mail site
		driver.get("https://www.fastmail.com/");

		Thread.sleep(5000); // do login
		driver.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("sreenuanumandla@fastmail.com");
		driver.findElement(By.name("password")).sendKeys("Veeru80@");
		driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
		Thread.sleep(3000);

	}

}
