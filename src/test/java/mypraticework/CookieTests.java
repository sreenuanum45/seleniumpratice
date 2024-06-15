package mypraticework;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.CookiesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CookieTests {
    RemoteWebDriver driver;
    CookiesUtility obj;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        obj = new CookiesUtility();

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testHomePageCookies() {
        driver.manage().window().maximize();
        driver.get("https://www.iplt20.com");

        int cookiesCount = obj.getCookiesCount(driver);
        System.out.println("Number of cookies on the homepage: " + cookiesCount);

        List<String> cookiesList = obj.getCookiesList(driver);
        System.out.println("List of cookies on the homepage: " + cookiesList);

        List<String> typesOfCookies = obj.getTypeofCookies(driver, "https://www.iplt20.com/", "https://www.iplt20.com/");
        System.out.println("Types of cookies on the homepage: ");
        for (String type : typesOfCookies) {
            System.out.println(type);
        }
    }

    @Test(priority = 2)
    public void testTeamsPageCookies() {
        driver.findElement(By.linkText("TEAMS")).click();

        int cookiesCount = obj.getCookiesCount(driver);
        System.out.println("Number of cookies on the teams page: " + cookiesCount);

        List<String> cookiesList = obj.getCookiesList(driver);
        System.out.println("List of cookies on the teams page: " + cookiesList);

        List<String> typesOfCookies = obj.getTypeofCookies(driver, "https://www.iplt20.com/", "https://www.iplt20.com/");
        System.out.println("Types of cookies on the teams page: ");
        for (String type : typesOfCookies) {
            System.out.println(type);
        }
    }
}
