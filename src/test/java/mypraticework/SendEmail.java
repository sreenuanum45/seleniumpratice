package mypraticework;

import org.testng.annotations.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendEmail {
    @Test
    public void method1() throws Exception {
        Properties p=new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.socketFactory.port", "465");
        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.put("mail.smtp.port", "465");
        p.put("mail.smtp.auth", "true");
        Authenticator auth=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sreenuanumandla45@gmail.com","dllakognivwekvhx");
            }
        };
        Session s=Session.getDefaultInstance(p,auth);
        Message msg=new MimeMessage(s);
        msg.setFrom(new InternetAddress("sreenuanumandla45@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("gouthambogoju@gmail.com"));
        msg.setSubject("testing subject");
        BodyPart bp=new MimeBodyPart();
        bp.setText("hi manager\n hi navven pig");
        BodyPart bp1=new MimeBodyPart();
        String filename="E:\\anumandla sreenu resume.docx";
        DataSource source=new FileDataSource(filename);

        bp1.setDataHandler(new DataHandler(source));
     bp1.setFileName(filename);
     Multipart mpart=new MimeMultipart();
      mpart.addBodyPart(bp);
msg.setContent(mpart);
Transport.send(msg);

System.out.println("email send");





    }
}
