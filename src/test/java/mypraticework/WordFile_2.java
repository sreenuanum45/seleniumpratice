package mypraticework;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordFile_2 {
    @Test
    public void method1() throws IOException {
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph paragraph=doc.createParagraph();
        XWPFRun run =paragraph.createRun();
        run.setText("hi");

        File f = new File("src\\test\\resources\\Datafiles\\pratice2.docx");
        FileOutputStream fos = new FileOutputStream(f);
        doc.write(fos);
    }
}
