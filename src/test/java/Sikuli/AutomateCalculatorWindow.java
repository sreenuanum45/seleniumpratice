package Sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;

public class AutomateCalculatorWindow {
    @Test
    public void test1() throws IOException, InterruptedException, AWTException, FindFailed {
        Runtime.getRuntime().exec("calc.exe");
        Thread.sleep(3000);
        StringSelection x=new StringSelection("120");
        Thread.sleep(3000);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x,null);
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        Screen s=new Screen();
        Iterator<Match> l=s.findAll("E:\\caputureimages\\add.png");
        l.next().click();
        Thread.sleep(3000);
        StringSelection y=new StringSelection("50");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y,null);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        s.click("E:\\caputureimages\\equals.png");
        Thread.sleep(3000);
        r.keyPress(KeyEvent.VK_CONTEXT_MENU);
        r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        Thread.sleep(3000);
    }
}
