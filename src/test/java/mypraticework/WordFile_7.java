package mypraticework;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WordFile_7 {
    @Test
            public void method1() throws IOException, InvalidFormatException {
        File f = new File("src\\test\\resources\\Datafiles\\pratice4.docx");
        FileInputStream fos = new FileInputStream(f);
        XWPFDocument document = new XWPFDocument(fos);
        //document.addPictureData(fos, Document.PICTURE_TYPE_PNG);
        document.createTable();
        document.createTable().createRow().createCell().setText("hi");
    }



}
