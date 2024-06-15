package mypraticework;

import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileRead_7 {
    @Test(priority = 1)
    public void method1() throws IOException {
        File f = new File("src\\test\\resources\\Mydata.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        List<String>ls=new ArrayList<>();
        while((line=br.readLine())!=null)
        {
            int flag=0;
            for(int i=0;i<ls.size();i++)
            {
                if(line.equalsIgnoreCase(ls.get(i)));{
                    flag=1;
                    break;
            }
            }
            if(flag==1){
                ls.add(line);
            }

            }
        br.close();
        fr.close();
        FileWriter fw=new FileWriter(f);
        BufferedWriter bw=new BufferedWriter(fw);
        for(int i=0;i< ls.size();i++){
            bw.write(ls.get(i));
            bw.newLine();
        }
        bw.close();
        fw.close();

        }
    }

