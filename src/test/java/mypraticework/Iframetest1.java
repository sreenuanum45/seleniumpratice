package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Iframetest1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		String s = driver.findElement(By.tagName("p")).getText();
		System.out.println(s);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}

}
