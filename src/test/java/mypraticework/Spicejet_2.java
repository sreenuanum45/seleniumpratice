package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.DivTableUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Spicejet_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		// RemoteWebDriver driver=new ChromeDriver();
		ChromeOptions chromeOptionss= new ChromeOptions();

		// Disable notifications in Chrome
		chromeOptionss.addArguments("--disable-notifications");

		// Create a new ChromeDriver with the configured options
		RemoteWebDriver driver = new ChromeDriver(chromeOptionss);
		// open site
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		// search fights between given stations
		driver.findElement(By.xpath("//div[text()='From']/following::input[1]")).clear();
		driver.findElement(By.xpath("//div[text()='From']/following::input[1]")).sendKeys("Bengaluru (BLR)");
		driver.findElement(By.xpath("//div[text()='From']/following::input[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Delhi (DEL)");
		WebElement e = driver.findElement(By.xpath("//div[text()='Departure Date']"));
		driver.executeScript("arguments[0].scrollIntoView();", e);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='27'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		Thread.sleep(4000);
		WebElement dt = driver.findElement(By.xpath("//div[text()='SpiceMax']/following::div[2]"));
		DivTableUtility obj = new DivTableUtility();
		int numberofflight = obj.getChildDIVCount(dt);
		System.out.println(numberofflight);
		List<WebElement> Flights = obj.getChildDIVs(dt);
		int hfare = 0;
		for (WebElement Flight : Flights) {

			By b = By.xpath("child::div/div[2]/div[1]//span/parent::div");
			String value = obj.getDIVValue(driver, Flight, b);

			String num = value.replaceAll("[^0-9]", "");
			if (hfare == 0) {
				hfare = Integer.parseInt(num);
			} else if (hfare < Integer.parseInt(num)) {
				hfare = Integer.parseInt(num);
				WebElement
				 rb=Flight.findElement(By.xpath("child::div/div[2]/div[1]//*[name()='svg']"));
				 driver.executeScript("arguments[0].scrollIntoView();",rb);
				  Thread.sleep(2000); rb.click();


				Flight.findElement(By.xpath("child::div/div[2]/div[1]//*[name()='svg']")).click();
			}
		}
		System.out.println(hfare);

	}

}
