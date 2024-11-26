package mypraticework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTable_2 {
    @Test
    public void webTable() {
        Faker faker = new Faker();
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();
        WebElement from = driver.findElement(By.name("fromPort"));
       from.click();
        Select s=new Select(from);
        s.selectByValue("Boston");
        WebElement to = driver.findElement(By.name("toPort"));
        to.click();
        Select s1=new Select(to);
        s1.selectByValue("Rome");
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        List<WebElement>num_of_flights=driver.findElements(By.xpath("//table//tbody//tr"));
        System.out.println(num_of_flights.size());
        String[] prices=new String[num_of_flights.size()];
        for(int i=0;i<num_of_flights.size();i++){
            System.out.println();
            prices[i]=num_of_flights.get(i).findElement(By.xpath("td[6]")).getText().replace("$","");
        }
        for(int i=0;i<prices.length;i++){
            System.out.println(prices[i]);
        }
        //Arrays.stream(Arrays.stream(prices).toArray()).sorted().forEach(System.out::println);
        Arrays.sort(prices);
        String min_price=prices[0];
       String Max_price= prices[prices.length-1];
       for(int i=1;i<=num_of_flights.size();i++){
           if(driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[6]")).getText().replace("$","").equals(min_price)){
               num_of_flights.get(i).findElement(By.xpath("(//input[@type='submit'])["+i+"]")).click();
               break;
           }
       }
        Assert.assertEquals("Your flight from TLV to SFO has been reserved.", driver.findElement(By.xpath("//h2")).getText());
driver.findElement(By.cssSelector("#inputName")).sendKeys(faker.name().firstName());
driver.findElement(By.id("address")).sendKeys(faker.address().fullAddress());
driver.findElement(By.id("city")).sendKeys(faker.address().city());
driver.findElement(By.id("state")).sendKeys(faker.address().state());
driver.findElement(By.id("zipCode")).sendKeys(faker.address().zipCode());
WebElement card = driver.findElement(By.id("cardType"));
card.click();
Select s2=new Select(card);
s2.selectByValue("amex");
driver.findElement(By.id("creditCardNumber")).sendKeys(faker.number().digits(16));
driver.findElement(By.id("creditCardMonth")).sendKeys(faker.number().digits(2));
driver.findElement(By.id("creditCardYear")).sendKeys(faker.number().digits(4));
driver.findElement(By.id("nameOnCard")).sendKeys(faker.name().fullName());
driver.findElement(By.id("rememberMe")).click();
driver.findElement(By.xpath("//input[@type='submit']")).click();
Assert.assertEquals("Thank you for your purchase today!", driver.findElement(By.xpath("//h1")).getText());
    }
}
