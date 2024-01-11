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

//            loop through entries
            while(rs.next()) {
                System.out.println("\nID: " + rs.getInt(1) + "\nName: " + rs.getString(2) + "\nDomain: " + rs.getString(3) + "\nAddress: " + rs.getString(4));
            }
            System.out.println("\nEnd of entries!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean displaybyID(int id) {
//        reuse code from the entry method

        boolean check = false;
        try{
            Connection con = DB.getCon();
            String query = "Select * from profile where id= "+id;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                System.out.println("\nID: " + rs.getInt(1) + "\nName: " + rs.getString(2) + "\nDomain: " + rs.getString(3) + "\nAddress: " + rs.getString(4));
            }

            check = true;

        }
        catch (Exception e){
            System.out.println(e);
        }

        return check;
    }

    public boolean deleteEntry(int toDelete) {
        boolean check = false;
        try{
            Connection con = DB.getCon();
            String query = "delete from profile where id= "+toDelete;

//            Run command to delete entry
            PreparedStatement p = con.prepareStatement(query);
            p.executeUpdate();

            check = true;

        }
        catch (Exception e){
            System.out.println(e);
        }

        return check;
    }

    public boolean updateEntry(String newName, String newDomain, String newAddress, int id) {
//        make use of MySQL update command for final crud operation

        boolean check = false;
        try{
            Connection con = DB.getCon();
            String query = new StringBuilder().append("UPDATE profile set name=\'").append(newName).append("\', domain=\'").append(newDomain).append("\', address=\'").append(newAddress).append("\' where id=").append(id).toString();

//            Run command to delete entry
            PreparedStatement p = con.prepareStatement(query);
            p.execute();
            System.out.println("Successfully updated");

            System.out.println("Updated profile:\n");

            String checkQuery = "Select * from profile where id= "+id;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(checkQuery);

            while(rs.next()) {
                System.out.println("\nID: " + rs.getInt(1) + "\nName: " + rs.getString(2) + "\nDomain: " + rs.getString(3) + "\nAddress: " + rs.getString(4));
            }
            check = true;
        }
        catch (Exception e){
            System.out.println(e);
        }

        return check;
    }
}
