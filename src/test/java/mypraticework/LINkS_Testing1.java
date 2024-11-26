package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.LinksUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LINkS_Testing1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Launch google
		driver.get("https://www.flipkart.com/");
		Thread.sleep(7000);
		// collect all links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		List<String> links1 =links
				.stream()
				.filter(ele-> !ele.getText().equals("")&&ele.getText().startsWith("flipkart"))
				.map(x->x.getText())
				.flatMap(y->Stream.of(y))
				.collect(Collectors.toList());
		String firstLink=links.stream().filter(ele-> !ele.getText().equals("")).findFirst().get().getText();
		System.out.println(firstLink);
		links1.forEach(System.out::println);
		System.out.println(links1.size());
		String findany=links.stream().filter(ele-> !ele.getText().equals("")).findAny().map(x->x.getText().trim()).get();
		System.out.println("findAny:"+findany);
		LinksUtility lu = new LinksUtility();
		lu.linksInPage(links);
		// lu.linksInPage(links1);
		driver.quit();
	}
}