import Connectivity.DB;

import java.sql.*;

public class AddAction {

    public boolean add(StudentProfile sp) {
        boolean check = false;
        try{
            Connection con = DB.getCon();

//            Insert add query to sql
            String query = "insert into profile(name, domain, address) value(?,?,?)";

//                        For testing purposes, use assert() to test validity of connection
            assert con != null;
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, sp.getName());
            p.setString(2, sp.getDomain());
            p.setString(3, sp.getAddress());

//            execute query
            p.executeUpdate();
            check = true;

        }
        catch (Exception e){
            System.out.println(e);
        }

        return check;
    }

    public void display() {

        try{
            Connection con = DB.getCon();
            String query = "Select * from profile";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}