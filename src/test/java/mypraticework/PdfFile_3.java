package mypraticework;

import com.itextpdf.text.exceptions.InvalidPdfException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class PdfFile_3 {
    @Test
    public void method1()throws InvalidPdfException {
        try {
            // Load the PDF files
            File f=new File("src\\test\\resources\\Datafiles\\practice1.pdf");
            FileInputStream fis=new FileInputStream(f);
            PdfReader pdfReader1 = new PdfReader("src\\test\\resources\\Datafiles\\practice2.pdf");
            PdfReader pdfReader2 = new PdfReader(fis);
int x=pdfReader1.getNumberOfPages();
            // Extract text content from both PDF files
            String text1 = PdfTextExtractor.getTextFromPage(pdfReader1, 1);
            String text2 = PdfTextExtractor.getTextFromPage(pdfReader2, 1);

            // Compare the text content
            if (text1.equals(text2)) {
                System.out.println("The PDF files have the same content.");
            } else {
                System.out.println("The PDF files have different content.");
            }

            // Close the PDF readers
            pdfReader1.close();
            pdfReader2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
