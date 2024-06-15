package mypraticework;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WordFile_3_Extractor {
    @Test
    public void method1() throws IOException {
        File f=new File("src\\test\\resources\\Datafiles\\pratice2.docx");
        FileInputStream fos=new FileInputStream(f);
        XWPFDocument document=new XWPFDocument(fos);
        XWPFWordExtractor ex=new XWPFWordExtractor(document);
        System.out.println(ex.getText());
        ex.close();
    }
}
