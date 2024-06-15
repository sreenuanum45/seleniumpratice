package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class CollectInputTags_1 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		// Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch site
		driver.get("https://www.amazon.in");
		Thread.sleep(5000);
		// Collect all <input> tag elements
		List<WebElement> l = driver.findElements(By.xpath("//input"));
		System.out.println("total input tags in pagesource:" + l.size());
		int button = 0;
		int cheeckbox = 0;
		int colour = 0;
		int date = 0;
		int email = 0;
		int file = 0;
		int hidden = 0;
		int image = 0;
		int password = 0;
		int range = 0;
		int reset = 0;
		int submit = 0;
		int text = 0;
		int url = 0;
		int others = 0;
		for (WebElement e : l) {
			String x = e.getAttribute("type");
			switch (x) {
			case "text":
				text++;
				break;
			case "submit":
				submit++;
				break;
			case "cheeckbox":
				cheeckbox++;
				break;
			case "hidden":
				hidden++;
				break;
			case "file":
				file++;
				break;
			case "url":
				url++;
				break;
			default:
				others++;
				System.out.println(x);

			}

		}
		System.out.println("count of text:" + text);
		System.out.println("count of submit:" + submit);
		System.out.println("count of hidden: " + hidden);
		System.out.println("count of others:" + others);

	}

}
