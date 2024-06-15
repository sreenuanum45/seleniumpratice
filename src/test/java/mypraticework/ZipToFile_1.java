package mypraticework;

import mypractice_utility.FileTozipUtiliy;
import org.testng.annotations.Test;



public class ZipToFile_1 {
    @Test
    public void method1() throws Exception {
        FileTozipUtiliy f1=new FileTozipUtiliy();
        f1.ZipToFile("E:\\anumandla sreenu resume.zip","E:\\sreenuimages\\anumandla sreenu resume.zip");
    }
}
