package AdvanceSeleniumPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.DivDropDownUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DivDropDown_1_Single {
    @Test
    public void method() throws Exception {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        //Launch site
        driver.get("https://semantic-ui.com/modules/dropdown.html");
       WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ui fluid selection dropdown'])[1]")));
        DivDropDownUtility dd=new DivDropDownUtility();
        //case1:
        if(dd.isMultiSelect(e)){
            System.out.println("multi select");
        }
        else {
            System.out.println("single select");
        }
        //case2
       int countofitems= dd.getItemsCount(e);
        System.out.println(countofitems);
        List<String> itemsnames=dd.getItemsNames(driver,e);
        for (String item:itemsnames){
            System.out.println(item.trim());
        }
        dd.selectItemByName(e,"Christian");
        dd.selectItemByIndex(e,1);

    }
}
