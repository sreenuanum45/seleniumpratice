package mypraticework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDown_1 {
    @Test
    public void selectDropDown() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
        Select s = new Select(dropdown);
List<WebElement>ls=s.getOptions();
System.out.println("number of option in dropdown"+ls.size());
/*for(int i=0;i<ls.size();i++)
{
    System.out.println(ls.get(i).getText());
}*/
        for(WebElement option:ls)
        {
            System.out.println(option.getText());
        }
        if(s.isMultiple()) {
            for (int i = 0; i < ls.size(); i++) {
                s.selectByIndex(i);
            }
        }
            else{
                s.selectByIndex(1);
            }
            s.getWrappedElement().click();

    }
}
