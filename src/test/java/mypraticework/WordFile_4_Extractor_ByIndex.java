package mypraticework;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class WordFile_4_Extractor_ByIndex {
    @Test
    public void method1() throws IOException {
        File f = new File("src\\test\\resources\\Datafiles\\pratice3.docx");
        FileInputStream fos = new FileInputStream(f);
        XWPFDocument document=new XWPFDocument(fos);
        int paraindex=0;
        List<XWPFParagraph>paragraphs=document.getParagraphs();
        System.out.println(paragraphs.size());
        if(paraindex>=0&&paraindex<paragraphs.size()){
            XWPFParagraph sp=paragraphs.get(paraindex);
            System.out.println(sp.getText());
        }
        else {
            System.out.println("Invalid paragraph index");
        }
        document.close();
        fos.close();
    }
}
