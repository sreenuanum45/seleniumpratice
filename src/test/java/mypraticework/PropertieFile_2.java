package mypraticework;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropertieFile_2 {
    @Test
    public void method1 () throws Exception
    {
        File f=new File("src/test/resources/config.properties");
        FileReader fr=new FileReader(f);
        Properties properties=new Properties();
        properties.load(fr);
        System.out.println("count of properties:"+properties.keySet().size());
        System.out.println(properties.getProperty("name"));

    }
}
