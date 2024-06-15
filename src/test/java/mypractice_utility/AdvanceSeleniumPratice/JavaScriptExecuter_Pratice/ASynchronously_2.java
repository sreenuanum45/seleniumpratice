package mypractice_utility.AdvanceSeleniumPratice.JavaScriptExecuter_Pratice;

import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class ASynchronously_2 {
    @Test
    public void method() throws Exception {
        //Open browser and launch site
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Launch site
        driver.get("https://users.cs.cf.ac.uk/Dave.Marshall/Internet/FRAMES/nested_frame.html");
        Thread.sleep(5000);
        //write JavaScript statements individually
        ScriptKey sk1 = driver.pin("return(window.frames.length);");
        ScriptKey sk2 = driver.pin("var frames=window.frames;");
        ScriptKey sk3 = driver.pin("frames[3].location='https://www.bbc.com';");
        ScriptKey sk4 = driver.pin("frames[4].location='https://www.magnitia.com';");
        ScriptKey sk5 = driver.pin("frames[2].location='https://www.google.co.in';");
        ScriptKey sk6 = driver.pin("frames[1].location='https://www.amazon.in';");
        Set<ScriptKey> ls= driver.getPinnedScripts();

        for(ScriptKey s:ls){
            System.out.println(s);
        driver.unpin(s);
        }
        driver.close();

    }
}
