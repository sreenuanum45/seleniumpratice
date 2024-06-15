package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Yahoo_1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
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
		driver.findElement(By.linkText("Compose")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("message-to-field")).sendKeys("sreenuanumandla@fastmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("my test pratice");
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("hi bro how are you");
		driver.findElement(By.xpath("//input[@type='file']"))
				.sendKeys("C:\\Users\\sreenu\\OneDrive\\Pictures\\Screenshot 2023-02-13 193110.png");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@title='Send this email']")).click();
		String s = driver.findElement(By.xpath("//div[@role='presentation']/following-sibling::div[1]")).getText();
		System.out.println(s);
		// new tab or window
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> s1 = driver.getWindowHandles();
		List<String> l1 = new ArrayList<>(s1);
		// switch to that new window
		driver.switchTo().window(l1.get(1));
		// Launch fast mail site
		driver.get("http://www.fastmail.com");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//[text()='Log in']/parent::a")).click();
		Thread.sleep(10000);
		driver.findElement(By.name("username")).sendKeys("sreenuanumandla@fastmail.com");
		driver.findElement(By.name("password")).sendKeys("Veeru80@");
		driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
		Thread.sleep(5000);
		String a = driver.findElement(By.xpath(
				"//ul[contains(@class,'v-Mailbox')]/li[1]/a/div//span//span[@title='sreenuanumandla@yahoo.com']"))
				.getAttribute("title");
		if (a.equals("sreenuanumandla@yahoo.com")) {
			System.out.println("From address Test passed");
		} else {
			System.out.println("From address Test failed");
		}
		String b = driver.findElement(By.xpath("//ul[contains(@class,'v-Mailbox')]/li[1]/a/div[4]"))
				.getAttribute("title");
		if (b.equals("my test pratice")) {
			System.out.println("subject Test passed");
		} else {
			System.out.println("subject Test falied");
		}

		// logout
		driver.findElement(By
				.xpath("//div[contains(@class,'v-MainNavToolbar-userName u-hideifempty u-trim u-overflow-padtrim ')]"))
				.click();
		driver.findElement(By.xpath("Log out")).click();
		Thread.sleep(10000);
		driver.close(); // close fast mail
		driver.switchTo().window(l1.get(0)); // back to yahoo mail
		// Logout in yahoo mail
		driver.findElement(By.id("ybarAccountMenuOpener")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("profile-signout-link")).click();
		Thread.sleep(10000);
		driver.close(); // close yahoo mail
	}

}
