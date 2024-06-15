package mypraticework;

import org.testng.annotations.Test;

import java.util.Properties;
import java.util.Set;

public class PropertieFile_4 {
    @Test
    public void method1 () throws Exception
    {
        Properties p=System.getProperties();
        Set<Object>s=p.keySet();
        for(Object ss: s){
            System.out.println(ss.toString()+"="+p.getProperty(ss.toString()));

        }
    }
}
