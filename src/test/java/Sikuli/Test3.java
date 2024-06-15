package Sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

public class Test3 {
    public static void main(String[] args) throws Exception {
        //Create an empty folder if not exists
        File fo = new File("src\\test\\resources\\mydownloads");
        fo.mkdir();
        //Store preferences/arguments with values as pairs in a hash map
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("profile.default_content_settings.popups", 0); //0 means off
        hm.put("download.default_directory", fo.getAbsolutePath());
        hm.put("safebrowsing.enabled", true);
        //Set hash map pairs to chrome browser preferences
        ChromeOptions co = new ChromeOptions();
        co.setExperimentalOption("prefs", hm); //"prefs" is a fixed command
        //Open browser with given preferences

        ChromeDriver driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //Launch site
        driver.get("https://selenium.dev/");
        driver.findElement(By.xpath("//*[text()='Downloads']")).click();
        Thread.sleep(5000);
    }
}
