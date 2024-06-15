package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IframeTest4 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		Thread.sleep(5000);
		driver.switchTo().frame("iframeResult");
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		System.out.println(driver
				.findElement(
						By.xpath("(//h1[normalize-space()='This page is displayed in an iframe'])/parent::body[1]"))
				.getText());

	}

}
