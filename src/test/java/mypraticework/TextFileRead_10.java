package mypraticework;

import org.testng.annotations.Test;

import java.io.*;

public class TextFileRead_10 {

        @Test
        public void method1 () throws Exception,NumberFormatException
        {
            File f=new File("src\\test\\resources\\MYvalue.txt");
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            File f1=new File("src\\test\\resources\\Output.txt");
            FileWriter fw=new FileWriter(f1);
            BufferedWriter bw=new BufferedWriter(fw);
            String line="";
            while ((line=br.readLine())!=null){
                String pieces[]=line.split(",");
                int a=Integer.parseInt((pieces[0]));
                int b=Integer.parseInt(pieces[2]);
                if (pieces[1].equalsIgnoreCase("add")) {
          String temp=""+(a+b);
          bw.write(temp);
          bw.newLine();
                }
                else if (pieces[1].equalsIgnoreCase("subtract")) {
                    String temp=""+(a-b);
                    bw.write(temp);
                    bw.newLine();

                } else if (pieces[1].equalsIgnoreCase("divide")) {
                    String temp=""+(a/b);
                    bw.write(temp);
                    bw.newLine();

                    
                } else   {

                    String temp=""+(a/b);
                    bw.write(temp);
                    bw.newLine();
                }



            }
            br.close();
            fr.close();
            bw.close();
            fw.close();

        }
    }

