package mypraticework;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileRead_6 {
    @Test(priority = 1)
    public void method1() throws IOException {
        File f = new File("src\\test\\resources\\Mydata.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        List<String> ls = new ArrayList<>();
        Pattern p = Pattern.compile("[A-Z a-z][a-z]+");

        while ((line = br.readLine()) != null) {
            Matcher m = p.matcher(line);
            while (m.find()) {
                System.out.println(m.group());
                ls.add(m.group());

            }
        }
        for(String s:ls){
            char f1=s.charAt(0);
            s=s.substring(1);
            if(f1>97){
                f1=(char)(f1-32);
            }
           s=f1+s;
            System.out.println(s);

        }
        br.close();
        fr.close();
    }
}
