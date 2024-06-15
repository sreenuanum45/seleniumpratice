package mypraticework;


import org.testng.annotations.Test;


public class Sqlconnection {
    @Test
    public void method1() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
      // Connection con=DriverManager.getConnection("");
      //  File f=new File("");
      //  File[]l=f.listFiles();
    }
}
