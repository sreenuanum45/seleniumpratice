package mypraticework;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;

public class PropertieFile_3 {
    @Test
    public void method1 () throws Exception
    {
        File f=new File("src/test/resources/config.properties");
        PropertiesConfiguration pc=new PropertiesConfiguration(f);
        pc.setProperty("password","7416472820");
        pc.save();
        FileReader fr=new FileReader(f);
        Properties p=new Properties();
        p.load(fr);
        Set<Object>Keys=p.keySet();
        for(Object key:Keys)
        {
        System.out.println("key.toString()+="+p.getProperty(key.toString()));
        }
    }
}
