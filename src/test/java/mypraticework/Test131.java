package mypraticework;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
import mypractice_utility.FileTozipUtiliy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Test131 {
    RemoteWebDriver driver;
    List<String>names;
    List<Integer>prices;
    ATUTestRecorder recorder;
    String vp;
    String zipfile;

    @Test(priority = 7)
    public void filetozip() throws IOException {
        FileTozipUtiliy f=new FileTozipUtiliy();
        File f1 = new File(vp+".mov");
        FileInputStream fis = new FileInputStream(f1);
        zipfile=vp+".zip";
        File f2 = new File(zipfile);
        FileOutputStream fos = new FileOutputStream(f2);
        ZipOutputStream zipout = new ZipOutputStream(fos);
        ZipEntry zipentry = new ZipEntry(f1.getName());
        zipout.putNextEntry(zipentry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes ))>=0) {
            zipout.write(bytes,0,length);
        }
        zipout.close();
        fis.close();
        fos.close();
        System.out.println("zip complete");
    }

    @Test(priority = 2)
    public void launch() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        try {
            driver.findElement(By.xpath(
                    "(//span[text()='Login'])[1]/preceding::button[1]")).click();
            Thread.sleep(5000);
        } catch (Exception ex1) {
            try {
                driver.findElement(By.xpath("//span[@role='button']")).click();
                Thread.sleep(5000);
            } catch (Exception ex2) {
                System.out.println("No banner for this time");
            }
        }
    }

    @Test(priority = 3)
    public void method3() throws Exception {
        driver.findElement(By.xpath("//span[text()='Mobiles']")).click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//p[text()='Realme']")).click();
        WebElement e = driver.findElement(By.name("q"));
        e.sendKeys("realme" + Keys.ENTER);
        int total = 0;
        prices=new ArrayList<>();
        names=new ArrayList<>();
        while (true) {
            List<WebElement> models = driver.findElements(By.xpath("//div[starts-with(@data-id,'MOB')]"));
            total=total+models.size();
            //(//div[starts-with(@data-id,'MOB')]//descendant::div[contains(@class,'col')])//div[1]/div[1]/div[1]
            for(WebElement model:models){
                String price=model.findElement(By.xpath("descendant::div[contains(@class,'col')])//div[1]/div[1]/div[1]")
                ).getText();
                if(!price.contains("not avalible")){
     String name=driver.findElement(By.xpath("div[contains(@class,'col')])//div[1]/div[1]/div[1]")).getText();
     names.add(name);
     price=price.substring(1);
     price=price.replace(",","");
     int p=Integer.parseInt(price);
     prices.add(p);

                }

            }
try{
    driver.findElement(By.xpath("//span[text()='Next']")).click();
    Thread.sleep(2000);
}catch (Exception ee){
    ee.getMessage();
    break;
    }
        }
        Reporter.log("Total models are "+total);
    }
    @Test (priority = 4 )
    public void method4()throws NullPointerException {

            // Initialize the prices and names lists here
            prices = new ArrayList<>();
            names = new ArrayList<>();

            if (prices.isEmpty() || names.isEmpty()) {
                // Handle the case where the lists are empty
                Reporter.log("Prices and/or names lists are empty.");
                return;
            }

            int maxprice = prices.get(0);
            String maxname = names.get(0);

            for (int i = 1; i < prices.size(); i++) {
                if (prices.get(i) > maxprice) {
                    maxprice = prices.get(i);
                    maxname = names.get(i);
                }
                Reporter.log("maximumpriceis:" + maxprice + " maxname " + maxname);
            }

            int min_price = prices.get(0);
            String min_name = names.get(0);

            for (int i = 1; i < prices.size(); i++) {
                if (prices.get(i) < min_price) {
                    min_name = names.get(i);
                    min_price = prices.get(i);
                }
            }

            Reporter.log("minimumpriceis:" + min_price + " min_name " + min_name);
        }



    @Test(priority=5, enabled=false)
    public void method5() throws Exception
    {
        //close browser
        driver.quit();
    }

    @Test(priority=6)
    public void method6() throws Exception
    {
        //stop recording
        recorder.stop();
    }
    @Test(priority=8)
    public void method8() throws Exception
    {
        Properties p=new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.socketFactory.port", "465");
        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.put("mail.smtp.port", "465");
        p.put("mail.smtp.auth", "true");
        Authenticator auth=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sreenuanumandla45@gmail.com","znymkdtfawajqddq");
            }
        };
        Session s=Session.getDefaultInstance(p,auth);
        Message msg=new MimeMessage(s);
        msg.setFrom(new InternetAddress("sreenuanumandla80@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("anumandlasreenu@gmail.com"));
        msg.setSubject("testing subject");
        BodyPart bp=new MimeBodyPart();
        bp.setText("hi manager\n please refer attached file");
        BodyPart bp1=new MimeBodyPart();
        String filename= zipfile;
        DataSource source=new FileDataSource(filename);

        bp1.setDataHandler(new DataHandler(source));
        bp1.setFileName(filename);
        Multipart mpart=new MimeMultipart();
        mpart.addBodyPart(bp);
        msg.setContent(mpart);
        Transport.send(msg);

        System.out.println("email send");
    }
    @Test(priority = 1)
    public void StartRecording() throws ATUTestRecorderException {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyy-hh-mm-ss");
        Date date = new Date();
        vp = "target\\" + sf.format(date);
        recorder = new ATUTestRecorder(vp, true);
        recorder.start();
    }
    }


