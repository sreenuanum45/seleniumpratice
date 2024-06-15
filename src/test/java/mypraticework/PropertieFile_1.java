package mypraticework;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

public class PropertieFile_1 {
    @Test
    public void method1 () throws Exception
    {
        Properties p=new Properties();
       p.setProperty("name","sreenu");
        p.setProperty("email","anumandlasreenu@gmail.com");
        File f=new File("src/test/resources/config.properties");
        FileWriter fw=new FileWriter(f,true);
       p.store(fw,"msg to display");

    }
}
