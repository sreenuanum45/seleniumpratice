package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Openchromedriver2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 2nd type
		// download the latest the chromedriver software to run
		// browser window can not close at the end of program exceution
		WebDriverManager.chromedriver().setup();
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://www.flipkart.com");
		driver1.manage().window().maximize();
		/*
		 * driver1.getCurrentUrl(); driver1.getPageSource(); driver1.getTitle();
		 */
		Thread.sleep(2222);
		driver1.close();

	}

}
