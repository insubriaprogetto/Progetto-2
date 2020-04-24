package bitti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ConnectionDbIP {

         String url = "jdbc:postgresql://";
        String user;
        String password;
        Connection conn;

     public ConnectionDbIP(String ur, String us, String ps) throws SQLException {

         url = url + ur + "/" + "Dbprogetto2";
         user = us;
         password = ps;

            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = connect();
           
         
     }
     
     
   
     

     Connection connect() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }

     public static void main(String[] args) throws SQLException {
         // TODO Auto-generated method stub
    	 
    	 String a ="localhost";
         String user = "postgres";
         String psw = "123";
         
         ConnectionDbIP db = new ConnectionDbIP(a, user,psw);
         System.out.println(db);

     }

}
