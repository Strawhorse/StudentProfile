import Connectivity.DB;

import java.sql.Connection;

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

    public StudentProfile(int id, String name, String domain, String address) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.address = address;
    }

    public static void main(String[] args) {
//
        DB db = new DB();

    }
}