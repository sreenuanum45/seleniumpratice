package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Testpratice1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("http://www.fastmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Log in']/parent::a")).click();
		Thread.sleep(15000);
		// driver.switchTo().activeElement().sendKeys("sreenuanumandla@fastmail.com",Keys.TAB);
		// driver.switchTo().activeElement().sendKeys("Veeru80@",Keys.TAB);
		driver.findElement(By.name("username")).sendKeys("sreenuanumandla");
		driver.findElement(By.name("password")).sendKeys("Veeru80@");
		// driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Inbox']")).click();
		Thread.sleep(3000);
		String s1 = driver.findElement(By.xpath("//span[@title='sreenuanumandla@yahoo.com']")).getText();
		System.out.println(s1);

	}

}
