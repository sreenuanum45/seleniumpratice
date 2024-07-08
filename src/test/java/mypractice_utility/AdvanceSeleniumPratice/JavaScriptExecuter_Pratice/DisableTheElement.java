package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DisableTheElement {
    @Test
    public void method() throws Exception {
        // Open browser and launch site
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.co.in");
        Thread.sleep(5000);

        // Execute JavaScript to interact with the element
        String script = "var e = document.getElementsByName('q')[0];" +
                "e.value = 'bse sensex';" +
                "e.style.background = 'pink';" +
                "e.style.border = '5px dotted yellow';" +
                "e.value = 'kalam';" +
                "e.disabled = true;";
        driver.executeScript(script);

        Thread.sleep(10000);

        // Enable the element again and change styles
        script = "e.disabled = false;" +
                "e.style.background = 'red';" +
                "e.style.border = '5px dotted blue';";
        driver.executeScript(script);

        Thread.sleep(5000);

        // Close the browser
        driver.quit();
    }
}
