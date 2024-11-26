package AdvanceSeleniumPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SelectDropDown_1 {
    @Test
    public void method() throws IOException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        WebElement e=driver.findElement(By.id("searchDropdownBox"));
        Select s=new Select(e);
        if(s.isMultiple()){
            System.out.println("multi selected drop down");
        }
        else {
            System.out.println("single selected drop down");
        }
       List<WebElement>l= s.getOptions();
        System.out.println("size of select drop down"+l.size());
        for(WebElement option:l){
            System.out.println(option.getText());
        }
        s.selectByValue("search-alias=alexa-skills");
        s.selectByIndex(2);
        s.selectByVisibleText("Amazon Devices");
        System.out.println(s.getOptions());
        File F=new File("E:\\sreenuimages\\dropdown.png");
       File src=s.getWrappedElement().getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, F);
    }
}
