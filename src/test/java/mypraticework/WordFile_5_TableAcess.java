package mypraticework;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class WordFile_5_TableAcess {
    @Test
    public void method1() throws IOException {
        File f = new File("src\\test\\resources\\Datafiles\\pratice4.docx");
        FileInputStream fos = new FileInputStream(f);
        XWPFDocument document = new XWPFDocument(fos);
        int ti=0;
        int r1=2;
        int c1=1;
        List<XWPFTable>listoftablesindocument=document.getTables();
        System.out.println(listoftablesindocument.size());
        XWPFTable targettable=listoftablesindocument.get(ti);
        List<XWPFTableRow>rows=targettable.getRows();
       XWPFTableRow row= rows.get(r1);
       XWPFTableCell cell =row.getCell(c1);
      System.out.println( cell.getText());
       document.close();
       fos.close();

    }
}
