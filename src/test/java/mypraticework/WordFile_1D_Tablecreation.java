package mypraticework;

import org.apache.poi.xwpf.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordFile_1D_Tablecreation {
    @Test
    public void  m1() throws IOException {
        XWPFDocument xwpfDocument = new XWPFDocument();
        XWPFParagraph xwpfParagraph = xwpfDocument.createParagraph();
        xwpfParagraph.setAlignment(ParagraphAlignment.LEFT);

        int numberofrows=20;
        int numberofcolumns=20;
        XWPFTable table=xwpfDocument.createTable(numberofrows,numberofcolumns);
        table.setWidth(100);
        for(int row=0;row<numberofrows;row++){
            XWPFTableRow tableRow=table.getRow(row);

            for(int column=0;column<numberofcolumns;column++){
             XWPFTableCell tableCell=tableRow.getCell(column);
          XWPFParagraph xwpfParagraph1 = tableCell.addParagraph();
          XWPFRun run=xwpfParagraph1.createRun();
                run.setText("Row " + (row + 1) + ", Column " + (column + 1));
            }
        }
        File f=new File("src\\test\\resources\\Datafiles\\TableCreation.docx");
        FileOutputStream fos=new FileOutputStream(f);
        xwpfDocument.write(fos);
        xwpfDocument.close();
        fos.close();
    }

}
