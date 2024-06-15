package mypraticework;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfFile_4 {
    @Test
    public void m1() throws IOException, DocumentException {
        File f=new File("src\\test\\resources\\Datafiles\\practice2.pdf");
        FileInputStream fis=new FileInputStream(f);
        PdfReader pr=new PdfReader(fis);
        //writemode
        FileOutputStream fos=new FileOutputStream(f);
        PdfStamper stamper=new PdfStamper(pr,fos);
        PdfContentByte cb=stamper.getUnderContent(1);
        Font font=FontFactory.getFont(FontFactory.COURIER,12, BaseColor.RED);
        Phrase p=new Phrase("hello",font);
        ColumnText ct=new ColumnText(cb);
     ct.setSimpleColumn(100,800,800,1000);
     ct.setText(p);
     ct.go();
     //add image
     Image image=Image.getInstance("C:\\Users\\sreenu\\OneDrive\\Pictures\\Screenshot 2023-02-13 193110.png");
     image.scaleToFit(300,200);
     image.setAbsolutePosition(100,100);
     image.scaleAbsolute(300,200);
     image.scaleAbsolute(100,100);
     cb.addImage(image);
     stamper.close();
     pr.close();



    }
}
