package mypraticework;

import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TextFileRead_11 {
    @Test
    public void method1 () throws Exception
    {

        File f1=new File("src/test/resources/Test1.txt");
        FileWriter fw=new FileWriter(f1,true);
        BufferedWriter bw=new BufferedWriter(fw);
        String s="<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->\n" +
                "<dependency>\n" +
                "    <groupId>io.github.bonigarcia</groupId>\n" +
                "    <artifactId>webdrivermanager</artifactId>\n" +
                "    <version>5.5.3</version>\n" +
                "</dependency>";
        bw.write(s);
bw.close();
    }
}
