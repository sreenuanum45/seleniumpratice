package DevtoolsExamples;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.security.Security;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class IgnoreSSLcertificate_errors {
    @Test
    public void test() throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        DevTools dt=((ChromeDriver)driver).getDevTools();
        dt.createSession();

        Command cmd1= Security.enable();
        System.out.println(cmd1.getSendsResponse());
        Command cmd2= Security.setIgnoreCertificateErrors(true);
        System.out.println(cmd2.getSendsResponse());
        dt.send(cmd1);
        dt.send(cmd2);
        dt.clearListeners();
        driver.get("https://expired.badssl.com/");
Thread.sleep(5000);
driver.close();
    }
}
