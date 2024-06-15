package mypraticework;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfFile_1 {
    @Test
    public void method1() throws IOException, InvalidFormatException, DocumentException {
        File f=new File("src\\test\\resources\\Datafiles\\practice2.pdf");
        FileOutputStream fos=new FileOutputStream(f);
        com.itextpdf.text.Document doc=  new com.itextpdf.text.Document();
        PdfWriter.getInstance(doc,fos);
        doc.open();
        Font F=FontFactory.getFont(FontFactory.HELVETICA,12,BaseColor.GREEN);
        F.getColor();
        Chunk c=new Chunk("hello",F);
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD,BaseColor.BLACK);
        Paragraph title = new Paragraph("PDF Utility Example", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);
        Paragraph text = new Paragraph("Anumandlasreenu", normalFont);
        doc.add(text);
        Image image = Image.getInstance("C:\\Users\\sreenu\\OneDrive\\Pictures\\Screenshot 2023-02-13 193110.png");
        image.scaleToFit(300, 200);
        doc.add(image);
        doc.add(title);
        doc.add(c);
        Paragraph p1=new Paragraph();
        p1.add("hi");
        Paragraph p2=new Paragraph();
        p2.add("hello");
        Paragraph p3=new Paragraph();
        p3.add("bye");
        doc.add(p1);
        doc.add(p2);
        doc.add(p3);
        doc.close();




    }
    }

