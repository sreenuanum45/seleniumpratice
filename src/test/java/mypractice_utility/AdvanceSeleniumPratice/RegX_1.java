package mypractice_utility.AdvanceSeleniumPratice;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegX_1 {
    @Test
    public void method(){
        String x="India won 2nd World cup in india in 2011 for 150 crore people";
        Pattern p=Pattern.compile("[A-Z][a-z]+");
        Matcher m=p.matcher(x);
        int now = 0;
        while (m.find( )){
            now++;
            System.out.println(m.group());
        }
        System.out.println(now);

    }
}
