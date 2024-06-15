package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Edgedriver2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.cricbuzz.com");
		Thread.sleep(2222);
		WebElement e = driver.findElement(By.linkText("Live Scores"));
		System.out.println(e);
		e.click();
		driver.manage().window().maximize();
		// driver.close();

	}

}
