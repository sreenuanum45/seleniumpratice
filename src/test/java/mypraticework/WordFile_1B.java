package mypraticework;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordFile_1B {
    @Test
    public void  m1() throws IOException {
        XWPFDocument xwpfDocument = new XWPFDocument();
        XWPFParagraph xwpfParagraph = xwpfDocument.createParagraph();
        xwpfParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titilerun=xwpfParagraph.createRun();
        titilerun.setText("hello");
        titilerun.setItalic(true);
        titilerun.setBold(true);
        titilerun.addCarriageReturn();
        titilerun.setColor("FF0000");
        titilerun.setFontSize(19);
        XWPFParagraph xwpfParagraph1 = xwpfDocument.createParagraph();
        xwpfParagraph1.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titilerun1=xwpfParagraph1.createRun();
        titilerun1.setText("world");
        titilerun1.setItalic(true);
        titilerun1.setColor("FF0020");
        titilerun1.setFontSize(11);

        File f=new File("src\\test\\resources\\Datafiles\\test1.docx");
        FileOutputStream fos=new FileOutputStream(f);
        xwpfDocument.write(fos);
        xwpfDocument.close();
        fos.close();

    }
}
