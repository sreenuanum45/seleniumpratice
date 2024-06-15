package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FindelementTest {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://mrecexamcell.com");
		String w = driver.getWindowHandle();
		// get the active browser window id
		System.out.println(w);
		Thread.sleep(2000);
		String s1 = driver.getTitle();
		System.out.println(s1);
		// login with student
		if (s1.equals("BET e-Portal Login")) {
			System.out.println("title is correct");
		} else {
			System.out.println("title is wrong");
		}
		String s2 = driver.getCurrentUrl();
		if ((s2.contains("mrecexamce"))) {
			System.out.println("it is correct url");
		} else {
			System.out.println("wrong url");
		}
		if (s2.startsWith("https")) {
			System.out.println("Secured site");
		} else {
			System.out.println("un secured site");
		}
		driver.findElement(By.id("lnkLogins")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("lnkStudent")).click();
		Scanner scn = new Scanner(System.in);
		driver.findElement(By.id("txtUserId")).sendKeys(scn.nextLine());
		driver.findElement(By.id("txtPwd")).sendKeys(scn.nextLine());
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_lnkStuInfo")).click();
		driver.manage().window().maximize();
		Set<String> s11 = driver.getWindowHandles();
		List<String> L = new ArrayList<>(s11);
		System.out.println(s11);
		driver.switchTo().window(L.get(0));

		Thread.sleep(2000);

	}

}
