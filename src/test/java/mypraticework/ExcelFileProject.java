package mypraticework;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ExcelFileProject {
    Date date;
    RemoteWebDriver driver;
    File f;
    File f1;
    FileInputStream fis;
    FileReader fr;
    int nouc;
   int nour;
   Properties p;
   ATUTestRecorder recorder;
   SimpleDateFormat sf;
   Sheet sh=null;
    Workbook wb;


    //load the propertiesfile
    @Test(priority = 0)
    public void method1() throws IOException {
       f=new File("src/test/resources/config.properties") ;
       fr=new FileReader(f);
       p=new Properties();
       p.load(fr);
    }
    //get the properties from properties file
    @Test(priority = 1)
    public void method2() throws IOException {
        f1=new File(p.getProperty("testdatafilepath"));
       fis=new FileInputStream(f1);
        wb = WorkbookFactory.create(fis);
        sh= wb.getSheet("Sheet1");

        nour=sh.getPhysicalNumberOfRows();
        nouc=sh.getRow(0).getLastCellNum();

    }
    @Test(priority = 2)
    public void method3() throws IOException {
        String b= p.getProperty("browser");
        if(b.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver();
        }
        else if (b.equalsIgnoreCase("firefox"))
        {
            driver=new FirefoxDriver();
        }
        else if (b.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
        }
        else {
            fr.close();
            fis.close();
            wb.close();
            System.exit(0);
        }

    }
    @Test(priority = 3)
    public void method4() throws  InterruptedException {
        driver.manage().window().maximize();
        driver.get(p.getProperty("url"));
        Thread.sleep(Long.parseLong(p.getProperty("waittime")));
    }
    @Test(priority = 4)
    public void method5( ) throws ATUTestRecorderException, InterruptedException, IOException {
        FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
        sf=new SimpleDateFormat("dd-MMM-yyy-hh-mm-ss");
        date=new Date();
        String vp="target\\"+sf.format(date);
        recorder=new ATUTestRecorder(vp,true);
        recorder.start();
        sh.getRow(0).createCell(nouc).setCellValue("result on"+sf.format(date));
        for(int i=1;i<nour;i++){
            DataFormatter df=new DataFormatter();
            String a=df.formatCellValue(sh.getRow(i).getCell(0));
            String b=df.formatCellValue(sh.getRow(i).getCell(1));
            String c=df.formatCellValue(sh.getRow(i).getCell(2));
            String d=df.formatCellValue(sh.getRow(i).getCell(3));
            String e=df.formatCellValue(sh.getRow(i).getCell(4));

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframewrapper"));
            driver.findElement(By.name("name")).sendKeys(a);
            driver.findElement(By.name("password")).sendKeys(b);
            //Thread.sleep(Long.parseLong(p.getProperty("waittime")));
            WebElement ee=driver.findElement(By.xpath("//input[@type='email']"));
            ee.sendKeys(c);
           // driver.executeScript("arguments[0].value='"+c+"';",ee);
            if(d.equalsIgnoreCase("male")){
                driver.findElement(By.id("register_gendermale")).click();
            }
            else{
                driver.findElement(By.id("register_genderfemale")).click();
            }
            WebElement e1=driver.findElement(By.id("register_country"));
            Select select=new Select(e1);
            if(e.equalsIgnoreCase("india")){
                select.selectByIndex(0);
            }
            else if(e.equalsIgnoreCase("pakistan")){
                select.selectByIndex(1);
            }
            else if(e.equalsIgnoreCase("africa")){
                select.selectByIndex(2);
            }
            else if(e.equalsIgnoreCase("china")){
                select.selectByIndex(3);
            }
            else{
                select.selectByIndex(4);
            }
            Thread.sleep(Long.parseLong(p.getProperty("waittime")));
      driver.findElement(By.id("register_0")).submit();
      //String textappers=driver.findElement(By.tagName("h1")).getText();
           // Reporter.log(textappers);
            driver.switchTo().defaultContent();
            driver.navigate().refresh();
        }
        FileOutputStream fos=new FileOutputStream(f1);
        wb.write(fos);
    }
    }




