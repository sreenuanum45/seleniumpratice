package AdvanceSeleniumPratice.RobotclassPratice;

import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
public class AutomateCalculatorWindow {
    @Test
    public void test() throws IOException, AWTException, InterruptedException, UnsupportedFlavorException {
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
        r.keyPress(KeyEvent.VK_ADD);
        r.keyRelease(KeyEvent.VK_ADD);
        Thread.sleep(3000);
        StringSelection y=new StringSelection("50");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y,null);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        r.keyPress(KeyEvent.VK_EQUALS);
        r.keyRelease(KeyEvent.VK_EQUALS);
        Thread.sleep(3000);
        r.keyPress(KeyEvent.VK_CONTEXT_MENU);
        r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        Thread.sleep(3000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        Thread.sleep(3000);
        String z=(String) Toolkit.getDefaultToolkit().getSystemClipboard()
                .getData(DataFlavor.stringFlavor);
        System.out.println(z);
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_F4);
        r.keyRelease(KeyEvent.VK_F4);
        r.keyRelease(KeyEvent.VK_ALT);
    }
}
