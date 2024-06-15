package mypraticework;

import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class WordFile_1A {
    @Test
    public void m1() throws IOException {

            XWPFDocument doc = new XWPFDocument();
            XWPFHeader header = doc.createHeader(HeaderFooterType.DEFAULT);
        header.createTable(1,2);
        header.getPartType();
            XWPFParagraph headerParagraph = header.createParagraph();
            XWPFRun run = headerParagraph.createRun();
            run.setItalic(true);
            run.text();
            run.setText("hello alll,happy weakooff");
            XWPFParagraph paragraph = doc.createParagraph();
            paragraph.setNumID(BigInteger.valueOf(1));
            XWPFRun run1 = paragraph.createRun();
            run1.setText("Anumandla sreenu");
            run1.addCarriageReturn();
            run1 = paragraph.createRun();
            paragraph.setNumID(BigInteger.valueOf(2));
            run1.setText("Anumandla veeresh");
            run1.addCarriageReturn();
            File f = new File("src\\test\\resources\\Datafiles\\pratice1.docx");
            FileOutputStream fos = new FileOutputStream(f);
            doc.write(fos);
            doc.close();
            fos.close();
            System.out.println("Word document created successfully.");


    }
}
