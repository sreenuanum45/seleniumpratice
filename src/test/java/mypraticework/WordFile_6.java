package mypraticework;

import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordFile_6 {
    @Test
    public void method1() throws IOException, InvalidFormatException {
        try {
            File inputFile = new File("src\\test\\resources\\Datafiles\\practice4.docx");
            FileInputStream fis = new FileInputStream(inputFile);
            XWPFDocument document = new XWPFDocument(fis);

            File imageFile = new File("C:\\Users\\sreenu\\OneDrive\\Pictures\\Attachment.jpeg");
FileInputStream fos=new FileInputStream(imageFile);
           document.createParagraph().createRun().addPicture(fos, PictureType.JPEG,"Attachment",10,20);
           /* XWPFPicture picture = document.createParagraph().createRun()
                    .addPicture(new FileInputStream(imageFile), XWPFDocument.PICTURE_TYPE_JPEG);*/

            FileOutputStream out = new FileOutputStream(inputFile);
            document.write(out);
            out.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    }


