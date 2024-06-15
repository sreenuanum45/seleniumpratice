package mypraticework;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileRead_3 {
    @Test
            public void method() throws IOException {
        File f=new File("D:\\batch264\\264pratice\\target\\Mydata.txt");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        int count=0;
        String line="";
        while ((line=br.readLine())!=null){
            count++;
            if(count==1||count==100||count==2){
                System.out.println(line);
            }

        }
        System.out.println("count of lines:"+count);
        br.close();
        fr.close();
    }

}
