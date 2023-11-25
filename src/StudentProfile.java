import Connectivity.DB;

import java.sql.Connection;
import java.util.Scanner;

public class StudentProfile {


    private int id;
    private String name;
    private String domain;
    private String address;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDomain(){
        return domain;
    }
    public void setDomain(String domain){
        this.domain = domain;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }


//    default constructor
    public StudentProfile(){
        System.out.println("Created...");
    }

    public StudentProfile(int id, String name, String domain, String address) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.address = address;
    }

    public StudentProfile(String name, String domain, String address) {
        this.name = name;
        this.domain = domain;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id->" + id +
                ", name->'" + name + '\'' +
                ", domain->'" + domain + '\'' +
                ", address->'" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
//
//      // create scanner class to take in command line input

        Scanner scanner = new Scanner(System.in);
        System.out.println("Student Profile Portal");

        while(true) {
            System.out.println(
                "\nPress 1 to Add profile"+
                "\nPress 2 to Display profile"+
                "\nPress 3 to Display profile with ID"+
                "\nPress 4 to Delete profile"+
                "\nPress 5 to Update profile\n"+
                "\nPress 6 to Exit\n"
            );
        }

    }
}