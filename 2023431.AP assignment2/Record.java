import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Record{
    public String name;
    public int age;
    public String address;
    public ArrayList<String> grades;
    


    public Record(String name,int age,String address,ArrayList<String> grades){
        this.name=name;
        this.age=age;
        this.address=address;
        this.grades=grades;
       

    }

    public String Name(){
        return name;
    }

    public int Age(){
        return age;
    }

    public String Address(){
        return address;
    }

    public ArrayList<String> Grades(){
        return grades;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGrades(ArrayList<String> grades) {
        this.grades = grades;
    }
   




}