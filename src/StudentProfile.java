import Connectivity.DB;

import java.sql.Connection;
import java.util.Scanner;

public class StudentProfile {


    private int id;
    private String name;
    private String domain;
    private String address;


//    methods, getters, setters
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


//    for creating new profiles
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Student Profile Portal");

//        create instance of Addaction class here so it doesn't have to be reinstantiated each time
        AddAction aa = new AddAction();

        while(true) {
            System.out.println(
                "\nPress 1 to Add profile"+
                "\nPress 2 to Display profile"+
                "\nPress 3 to Display profile with ID"+
                "\nPress 4 to Delete profile"+
                "\nPress 5 to Update profile"+
                "\nPress 6 to Exit"+
                "\nEnter choice: "
            );

            int i = sc.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Add Profile\n");
                    System.out.println("Enter Name:");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter Domain:");
                    String domain = sc.nextLine();
                    System.out.println("Enter Address:");
                    String address = sc.nextLine();

//                    create database object
                    StudentProfile sp = new StudentProfile(name, domain, address);
                    System.out.println("Adding profile now ...");

                    boolean validEntry = aa.add(sp);

                    if (validEntry == true) {
                        System.out.println("Profile added successfully.");
                    } else {
                        System.out.println("Problem occurred.");
                    }

//                    User should get two messages during this operation
//                    Connection successful, then Profile added successfully
//                    Can be accessed from mysql command line with:
//                    use student;
//                    select * from profile;
//                    can also use check table profile to ensure table/database is operating properly

                    break;
                case 2:
                    System.out.println("Display Profile");
                    aa.display();
//                    outputs all entries in database using ResultSet

                    break;
                case 3:
                    System.out.println("Display Profile incl. ID");
                    System.out.println("\nEnter the ID you wish to output: ");
                    int choice = sc.nextInt();
                    System.out.println(new StringBuilder().append("You chose ID ").append(choice).toString());
                    boolean validID = aa.displaybyID(choice);
                    if(!validID){
                        System.out.println(new StringBuilder().append("Sorry, ID ").append(choice).append(" not found!").toString());
                    }
                    System.out.println("End of entry.");

                    break;

                case 4:
                    System.out.println("Delete Profile");
                    System.out.println("\nEnter the ID you wish to delete from database: ");
                    int toDelete = sc.nextInt();

                    boolean validDeleteID = aa.deleteEntry(toDelete);
                    if(validDeleteID){
                        System.out.println(new StringBuilder().append("ID ").append(toDelete).append(" deleted successfully!").toString());
                    } else {
                        System.out.println(new StringBuilder().append("Sorry, ID ").append(toDelete).append(" not found!").toString());
                    }

                    break;
                case 5:
                    System.out.println("Updating Profile");
                    System.out.println("\nEnter the ID you wish to update: ");
                    int toUpdate = sc.nextInt();

                    System.out.println("Enter New Name:");
                    sc.nextLine();
                    String newName = sc.nextLine();
                    System.out.println("Enter New Domain:");
                    String newDomain = sc.nextLine();
                    System.out.println("Enter Address:");
                    String newAddress = sc.nextLine();


                    boolean validUpdateID = aa.updateEntry(newName, newDomain, newAddress, toUpdate);

                    if(validUpdateID){
                        System.out.println(new StringBuilder().append("ID ").append(toUpdate).append(" updated successfully!").toString());
                    } else {
                        System.out.println(new StringBuilder().append("Sorry, ID ").append(toUpdate).append(" not found!").toString());
                    }

                    break;
                case 6:
                    System.out.println("Exit ...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        }



    }
}