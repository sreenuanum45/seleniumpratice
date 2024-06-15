package DevtoolsExamples;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.Optional;

public class MeasuringLoadTime {
    @Test
    public void test() throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        DevTools dt=((ChromiumDriver)driver).getDevTools();
        dt.createSession();
        Command cmd1 = Network.enable(Optional.of(10000000), Optional.empty(), Optional.empty());
        Command cmd2 = Network.emulateNetworkConditions(false, 100, 200000, 100000, Optional.of(ConnectionType.WIFI));
        dt.send(cmd1);
        dt.send(cmd2);
        dt.send(cmd1);
        dt.send(cmd2);
        dt.getDomains().disableAll();
        long st=System.currentTimeMillis();
       driver.get("https://www.google.com");
       long et=System.currentTimeMillis();
       System.out.println(et-st+"msec");
       driver.close();
    }
}
