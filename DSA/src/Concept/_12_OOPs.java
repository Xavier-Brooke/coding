package Concept;

import java.util.Random;

// Pen class
class Pen {
    String color ;
    int tip ;

    void setColor(String color) {
        this.color = color ;
    }

    void setTip(int tip) {
        this.tip = tip ;
    }
}

// Bank class
class Bank {
    public String username ;
    protected int account_number ;
    private String password ;

    void getDetails() {
        System.out.println("userName :- " + this.username);
        System.out.println("account_number :- " + this.account_number);
        System.out.println("password :- " + this.password);
    }

    String getPassword() {
        return this.password ;
    }

    void setPassword(String password) {
        this.password = password ;
        System.out.println("Password changed successfully");
    }

}

// Student class
class Student {
    String name ;
    int roll ;

    Student() {
        System.out.println("Default constructor is called");
    }

    Student(String name, int roll) {
        System.out.println("Parametrized constructor is called");
        this.name = name ;
        this.roll = roll ;
    }

    void getDetails() {
        System.out.println("Name :- " + this.name);
        System.out.println("Roll :- " + this.roll);
    }
}

public class _12_OOPs {

    // main function
    public static void main(String[] args) {

        Random rand = new Random() ;

        Student s1 = new Student("Xavier Brooke", rand.nextInt(200)+2) ;
        s1.getDetails() ;

        // Bank class Test Case
//        Bank c1 = new Bank() ;
//        c1.username = "Xavier Brooke" ;
//        c1.account_number = rand.nextInt(398734909)+1 ;
//        c1.setPassword("lskdjoiweWERSFD@#$lkj(*&");
//        c1.getDetails();

        // Pen class Test Case
//        Pen p1 = new Pen() ;
//        p1.setColor("Red");
//        p1.setTip(2);
//        System.out.println(p1.color) ;
//        System.out.println(p1.tip);
    }
}