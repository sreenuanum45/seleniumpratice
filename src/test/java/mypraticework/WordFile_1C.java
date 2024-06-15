package mypraticework;

import org.apache.poi.xwpf.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordFile_1C {
    @Test
    public void  m1() throws IOException {
        XWPFDocument xwpfDocument = new XWPFDocument();
        XWPFParagraph xwpfParagraph = xwpfDocument.createParagraph();
        xwpfParagraph.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun titilerun=xwpfParagraph.createRun();
        titilerun.setFontSize(11);
        titilerun.setText("hi selenium java");
        titilerun.setItalic(true);
        titilerun.addBreak(BreakType.TEXT_WRAPPING);
        titilerun=xwpfParagraph.createRun();
        titilerun.setFontSize(14);
        titilerun.setText("\u0001  i am a good boy");

        File f=new File("src\\test\\resources\\Datafiles\\test2.docx");
        FileOutputStream fos=new FileOutputStream(f);
        xwpfDocument.write(fos);
        xwpfDocument.close();
        fos.close();


    }
}
