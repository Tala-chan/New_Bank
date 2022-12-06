import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class User {
    Scanner inLine = new Scanner(System.in);
    String answ;
    int answInt;
    String name;
    int social;
    int accNum;
    Boolean hasAccount=false;
    public User(String name, int social, int accNum){
        this.name=name;
        this.social=social;
        this.accNum=accNum;
    }
    public void getUser() {
        System.out.println("_______USER DATA_______");
        System.out.println("Name: " + name);
        System.out.println("Social security number: " + social);
        System.out.println("Account number: " + accNum);
        System.out.println();
    }
    public void editUser(){
        while(true) {
            System.out.println("What would you like to edit?");
            System.out.println();
            System.out.println("Name (press 1)");
            System.out.println("Social security number (press 2)");
            answ = inLine.next();
            System.out.println();
            if (answ.equals("1")) {
                System.out.println("What's the new name?");
                answ = inLine.next();
                name = answ;
                getUser();
            }
            if (answ.equals("2")) {
                System.out.println("What's the new social credits number?");
                answInt = inLine.nextInt();
                social = answInt;
                getUser();
            }
            System.out.println("Anything else? (y/n)");
            answ=inLine.next();
            if(answ.equals("n")){
                break;
            }
        }
    }
    public int getSocial(){
        return social;
    }
    public void accountGot(){hasAccount=true;}
    public boolean accounted(){return hasAccount;}
}