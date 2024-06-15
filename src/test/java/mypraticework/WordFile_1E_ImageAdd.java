package mypraticework;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class WordFile_1E_ImageAdd {
    @Test
    public void  m1() throws IOException, InvalidFormatException {
        XWPFDocument xwpfDocument = new XWPFDocument();
        XWPFParagraph xwpfParagraph = xwpfDocument.createParagraph();
        XWPFRun run=xwpfParagraph.createRun();
        String imagepath="C:\\Users\\sreenu\\OneDrive\\Pictures\\Screenshots\\Screenshot 2023-05-11 202334.png";
        InputStream imageStream= Files.newInputStream(Path.of(imagepath));

       run.addPicture(imageStream, XWPFDocument.PICTURE_TYPE_PNG, "Screenshot 2023-05-11 202334.png", Units.toEMU(200), Units.toEMU(100));
        File f=new File("src\\test\\resources\\Datafiles\\PictureAdd.docx");
        FileOutputStream fos=new FileOutputStream(f);
        xwpfDocument.write(fos);
        xwpfDocument.close();
        fos.close();

    }
}
