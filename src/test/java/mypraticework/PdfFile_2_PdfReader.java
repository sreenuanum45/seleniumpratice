package mypraticework;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PdfFile_2_PdfReader {
    @Test
    public void method1() throws IOException, InvalidFormatException, DocumentException {
        File f = new File("src\\test\\resources\\Datafiles\\practice1.pdf");
        FileInputStream fis=new FileInputStream(f);

        PdfReader pr=new PdfReader(fis);
        String x= PdfTextExtractor.getTextFromPage(pr,1);
        System.out.println(x);
        pr.close();
    }
}
