package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Iframe12_windowhandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_links_target");
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.partialLinkText("Visit W3Schools")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		// 2nd goto window or tab
		Set<String> s = driver.getWindowHandles();
		List<String> l1 = new ArrayList<>(s);
		driver.switchTo().window(l1.get(1));
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(5000);
		// if we want to close window use driver .close only closed theindex1 window
		// else switch to first index(0) shift
		driver.switchTo().window(l1.get(0));
		driver.findElement(By.partialLinkText("Get your")).click();
		Thread.sleep(5000);
		// recollect the all windows handles
		s = driver.getWindowHandles();
		l1 = new ArrayList<>(s);
		System.out.println(l1);
		driver.switchTo().window(l1.get(2));
		driver.findElement(By.id("w3loginbtn")).click();
		Thread.sleep(5000);
		driver.switchTo().window(l1.get(1));
		driver.close();
	}

}
