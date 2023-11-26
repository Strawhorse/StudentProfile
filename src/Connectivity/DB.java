package Connectivity;
import java.sql.*;

public class DB {

//    create connection with database

    public static Connection getCon() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "root");
            System.out.println("Connection successful");
            return con;

        } catch (SQLException e) {
            System.out.println(e);
         } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }


}
