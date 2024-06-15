package mypractice_utility.AdvanceSeleniumPratice;

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
import java.util.Arrays;
import java.util.List;

public class DivDropDown_1_MultiSelected {
    @Test
    public void method() throws Exception {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(1000));
        //Launch site
        driver.get("https://semantic-ui.com/modules/dropdown.html");
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='skills']//parent::div)[1]")));
        DivDropDownUtility du=new DivDropDownUtility();
        if(du.isMultiSelect(e)){
            System.out.println("multi select");
        }
        else {
            System.out.println("single select");
        }
        //case2
        int countofitems= du.getItemsCount(e);
        System.out.println(countofitems);
        List<String> itemsnames=du.getItemsNames(driver,e);
        for (String item:itemsnames){
            System.out.println(item.trim());
        }
        String[] x={"Angular","Graphic Design","CSS"};
       du.selectItemsByNames(e,x);
     List<String> selectedItems= du.getAllSelectedItems(e);
     List<String>Expecteditmes= Arrays.asList(x);
    if(du.compareTwoLists(selectedItems,Expecteditmes)) {
        System.out.println("Selected test pass");
    }
    else {
        System.out.println("Selection test failed");
    }
   List<String>sl=du.getAllSelectedItems(e);
   System.out.println(sl);
   String[]c=sl.toArray(new String[0]);
   du.deselectItemsByNames(e,c);



    }
}
