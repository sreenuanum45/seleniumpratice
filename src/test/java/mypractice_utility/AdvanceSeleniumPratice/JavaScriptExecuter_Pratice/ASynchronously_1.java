package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class ASynchronously_1 {
    @Test
    public void method() throws Exception
    {
        //Open browser and launch site
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //Launch site
        driver.get("https://users.cs.cf.ac.uk/Dave.Marshall/Internet/FRAMES/nested_frame.html");
        Thread.sleep(5000);
        //write JavaScript statements individually
        ScriptKey sk1=driver.pin("return(window.frames.length);");
       // ScriptKey sk2=driver.pin("var frames=window.frames;");
        ScriptKey sk3=driver.pin("frames[3].location='https://vinothqaacademy.com/';");
        ScriptKey sk4=driver.pin("frames[4].location='https://vinothqaacademy.com/';");
        ScriptKey sk5=driver.pin("frames[2].location='https://vinothqaacademy.com/';");
        ScriptKey sk6=driver.pin("frames[1].location='https://vinothqaacademy.com/';");
        ScriptKey sk7=driver.pin("frames[0].location='https://vinothqaacademy.com/';");
        long n = (long) driver.executeScript(sk1);
        System.out.println(n);
        //Object x = driver.executeScript(sk2);
        //System.out.println(x);
        driver.executeScript(sk3);
        driver.executeScript(sk4);
        driver.executeScript(sk5);
        driver.executeScript(sk6);
        driver.executeScript(sk7);
        Set<ScriptKey> ls = driver.getPinnedScripts();
        for(ScriptKey s:ls)
        {
            System.out.println(s);
        }

        for (int i = 0; i < ls.size(); i++)
        {
            System.out.println(ls.iterator().hasNext());
        }
        }




    }

