package db;
import java.sql.Connection;
//import java.util.logging.Level;
//import java.util.logging.Logger; 
import java.sql.DriverManager;
public class MyConnection {
    private static final String username = "root";
    private static final String password = "hirumay22#";//com.mysql.cj.jdbc.Driver
    private static final String dataConn = "jdbc:mysql://localhost:3306/student_management";
    private static Connection con = null;
    
    public static Connection getConnection(){
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(dataConn,username,password);
//        String chid = "1086";  // The ID you want to print
//            new Print(chid, con);
        
    }    catch (Exception ex) {
       System.out.println(ex.getMessage());
    }
       return con;
  } 
   // Get the connection from MyConnection
Connection conn = MyConnection.getConnection();



    
}