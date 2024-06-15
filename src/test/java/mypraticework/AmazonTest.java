package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AmazonTest {
	RemoteWebDriver driver;
	@Test
	public  void amazonTest()throws Exception{
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Account & Lists']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("7416472820");

		driver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sreenu45@");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple iPhone");
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		Thread.sleep(4000);
		List<WebElement> ls1 = driver.findElements(By.xpath("//img[@class='s-image']"));
		System.out.println(ls1.size());
		for (int i = 0; i < ls1.size(); i++) {
			for (int j = 1; j >= i; j++) {
				ls1.get(i).click();
				Thread.sleep(4000);
				Set<String> st = driver.getWindowHandles();
				List<String> rs = new ArrayList<>(st);

				driver.switchTo().window(rs.get(1));

				WebElement ex = driver
						.findElement(By.xpath("(//div[@data-component-type='s-search-result'])[" + j + "]"));
				String pr = ex.findElement(By.xpath("child::span[@class='a-price-whole']")).getText();

				Thread.sleep(5000);

				pr = pr.replace(",", "");
				Thread.sleep(5000);
				List<String> listItemsPrice = new ArrayList<>();
				listItemsPrice.add(pr);
				System.out.println(pr);

				driver.close();

				driver.switchTo().window(rs.get(0));

				Thread.sleep(5000);
			}
		}

		try {
			Scanner scn = new Scanner(System.in);
			String s = scn.next();

			driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(s);
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple iPhone");
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			Thread.sleep(4000);
			List<WebElement> ls = driver.findElements(By.xpath("//div[@class='a-section']/child::div"));
			for (int i = 0; i < ls.size(); i++) {
				ls.get(i).click();

				Set<String> st = driver.getWindowHandles();
				List<String> rs = new ArrayList<>(st);
				System.out.println(rs.size());
				driver.switchTo().window(rs.get(0));
				String pr = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[10]")).getText();
				Thread.sleep(5000);
				pr = pr.replace(",", "");
				Thread.sleep(5000);
				List<String> listItemsPrice = new ArrayList<>();
				listItemsPrice.add(pr);
				System.out.println(pr);

				System.out.println(rs.size());

			}
		} catch (Exception e) {
			// TODO: handle exception

			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple iPhone");
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			Thread.sleep(4000);
			List<WebElement> ls11 = driver.findElements(By.xpath("//div[@class='a-section']/child::div"));
			for (int i = 0; i < ls11.size(); i++) {
				ls11.get(i).click();

				Set<String> st = driver.getWindowHandles();
				List<String> rs = new ArrayList<>(st);
				driver.switchTo().window(rs.get(1));
				String pr = driver.findElement(By.xpath("a-price-whole")).getText();
				Thread.sleep(5000);

				pr = pr.replace(",", "");
				Thread.sleep(5000);
				List<String> listItemsPrice1 = new ArrayList<>();
				listItemsPrice1.add(pr);
				System.out.println(pr);
				driver.close();
				driver.switchTo().window(rs.get(0));
				Thread.sleep(5000);
				System.out.println(listItemsPrice1.size());

			}

		}

	}
	@BeforeTest
	public  void setup()  {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}
	@AfterTest
	public void teardown (){
		driver.close();

	}
}
