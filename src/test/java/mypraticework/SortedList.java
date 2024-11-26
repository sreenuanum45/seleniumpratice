package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortedList {
    RemoteWebDriver driver;
    @Test
    public void sortedList() {
        driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        //sorted list
      //  Select select = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
        //unsorted list
        Select select = new Select(driver.findElement(By.xpath("//select[@id='colour']")));
        List<WebElement> options = select.getOptions();
        //List<WebElement> sorted = options.stream().sorted().collect(Collectors.toList());
        List<String>OriginalList=new ArrayList<>();
        List<String>tempList=new ArrayList<>();
        for (WebElement e : options) {
            OriginalList.add(e.getText());
            tempList.add(e.getText());
        }
        System.out.println("OriginalList before sorted:"+OriginalList);
        System.out.println("tempList before sorted:"+tempList);
        Collections.sort(tempList);
        System.out.println("OriginalList after sorted:"+OriginalList);
        System.out.println("tempList after sorted:"+tempList);
        if (OriginalList.equals(tempList)) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

    }
}
