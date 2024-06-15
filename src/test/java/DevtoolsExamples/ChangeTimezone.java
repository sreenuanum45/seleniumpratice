package DevtoolsExamples;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.Optional;

public class ChangeTimezone {
    @Test
    public void test() throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        DevTools dt=((ChromeDriver)driver).getDevTools();
        dt.createSession();
        Command cmd = Network.enable(Optional.empty(), Optional.empty(), Optional.empty());
        Command cmd1 = new Command("Emulation.setTimezoneOverride", ImmutableMap.of("timezoneId", "GMT-4"));
        dt.send(cmd);
        dt.send(cmd1);
        driver.get("https://momentjs.com");
        Thread.sleep(5000);
        driver.close();
    }
}
