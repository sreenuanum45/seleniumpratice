package DevtoolsExamples;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v85.performance.Performance;
import org.openqa.selenium.devtools.v85.performance.model.Metric;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
public class performanceMonitoringRetrievingMetrics {
    @Test
    public void test() throws InterruptedException {
        RemoteWebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.navigate().to("https://www.amazon.in");
        Thread.sleep(5000);
        //Create DevTools session
DevTools dt=((ChromeDriver)driver).getDevTools();
        dt.createSession();
        //Activate Performance Panel
        Command cmd1= Performance.enable(Optional.empty());
        dt.send(cmd1);
        System.out.println(cmd1.getMethod());
        Map<String,Object> map=cmd1.getParams();
        System.out.println(map);
        cmd1.getSendsResponse();
        System.out.println(cmd1.getSendsResponse());
System.out.println("=====");
        List<Metric> ms=dt.send(Performance.getMetrics());
        for(Metric m:ms)
        {

            System.out.println(m.getName()+"="+m.getValue());
        }
    }
    }

