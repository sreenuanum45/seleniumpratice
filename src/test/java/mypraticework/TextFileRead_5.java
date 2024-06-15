package mypraticework;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileRead_5 {
    @Test(priority = 1)
    public void method1() throws IOException {
        File f = new File("src\\test\\resources\\Mydata.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line=null;
        //Pattern p=Pattern.compile("[A-Z][a-z]+");
       // Pattern p=Pattern.compile("[a-z]+[-][0-9]+[/][0-9]");
        Pattern p=Pattern.compile("([0-9]{2}[/][A-Za-z]{3}[/][0-9]{4})");
        //([0-9]{2}[/][A-Za-z]{3}[/][0-9]{4})
        //Pattern p=Pattern.compile("[A-Z][A-Z]+");
       // Pattern p=Pattern.compile("[0-9]+");
        while ((line=br.readLine())!=null){
            Matcher m=p.matcher(line);
            while (m.find()){
                System.out.println(m.group());

            }
        }
        br.close();
        fr.close();

    }
    }

