package mypraticework;

import mypractice_utility.FileTozipUtiliy;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class FileToZip_1 {
    @Test
    public void method1() throws IOException ,FileNotFoundException{
    FileTozipUtiliy f1=new FileTozipUtiliy();
    f1.FiletoZip("E:\\anumandla sreenu resume.docx","E:\\anumandla sreenu resume.zip");
    }
}
