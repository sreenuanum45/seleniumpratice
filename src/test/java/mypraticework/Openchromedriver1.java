package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Openchromedriver1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 1 type
		WebDriver driver = WebDriverManager.operadriver().create();
		/*
		 * chromedriver() is static method it return the Webdrivermanager class object
		 * create() method is non static method but its return the WebDriver object
		 * create() method is to launch the browser
		 */
		// create method return the Webdriver object
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		// browser window close at the program exceution
		// if we given manually close broswe will close
		driver.close();

	}

}
