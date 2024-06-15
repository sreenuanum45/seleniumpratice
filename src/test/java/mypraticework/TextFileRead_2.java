package mypraticework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileRead_2 {
    public static void main(String[] args) throws IOException {
        File f=new File("D:\\batch264\\264pratice\\target\\Mydata.txt");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        int count=0;
        String line="";
        while ((line=br.readLine())!=null){
            count++;
            System.out.println(line);
        }
        System.out.println("count of lines:"+count);
    }
}
