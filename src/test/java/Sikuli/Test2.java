package Sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class Test2 {
   @Test
    public void test1() throws FindFailed, InterruptedException {
       RemoteWebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://demo.automationtesting.in/Register.html");
       WebElement e=driver.findElement(By.xpath("//input[@type='file']"));
    driver.executeScript("arguments[0].click();",e);
       String  imagefilepath="E:\\caputureimages\\";
       String inputFilepath="E:\\caputureimages";
       Screen s=new Screen();
       Pattern fileinputtext=new Pattern(imagefilepath+"Screenshot 2024-01-17 181746.png");
       Pattern open=new Pattern("E:\\caputureimages\\Screenshot 2024-01-17 181916.png");
       Thread.sleep(5000);
       s.wait(fileinputtext,20);
       s.type(fileinputtext,inputFilepath+"\\block1.png");
       s.click(open);



    }
}
