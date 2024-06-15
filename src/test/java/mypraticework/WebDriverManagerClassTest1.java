package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManagerClassTest1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager obj1 = WebDriverManager.chromedriver();
		obj1.setup();
		// System.out.print(obj1);

		RemoteWebDriver obj11 = new EdgeDriver();
		obj11.get("http://www.google.co.in");
		Thread.sleep(3000);
		obj11.manage().window().maximize();
		// get the curreent url of browser
		String s1 = obj11.getCurrentUrl();
		System.out.println(s1);
		String s3 = obj11.getTitle();
		System.out.println(s3);
		if (s1.startsWith("https")) {
			System.out.println("it is secured site");
		} else {
			System.out.println("it is unsecured");
		}
		obj11.findElement(By.linkText("Gmail")).click();
		Thread.sleep(5000);
		String s2 = obj11.getCurrentUrl();
		System.out.println(s2);
		String s4 = obj11.getTitle();
		System.out.println(s4);
		if (s1.startsWith("https")) {
			System.out.println("it is secured site");
		} else {
			System.out.println("it is unsecured");
		}

		Thread.sleep(5000);
		obj11.close();

	}

}
