package mypraticework;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileRead_4 {
    @Test(priority = 1)
    public void method1() throws IOException,java.io.FileNotFoundException {
        File f=new File("src\\test\\resources\\Mydata.txt");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        int ln=1;
        String line=null;
        while ((line= br.readLine())!=null)
        {
            String []pieces=line.split(" ");
            if(ln==1){
                System.out.println("1st line has  "+pieces.length  +"words");
                System.out.println(line);
            } else if (ln==2) {
                System.out.println("2st line has"+pieces.length+"words");
            }
            else {
               System.out.println(ln+"th line has"+pieces.length+"words");
                System.out.println(line);
            }
          ln++;
        }
        br.close();
        fr.close();
    }
}
