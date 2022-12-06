import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

class TheBank {
    Scanner inLine = new Scanner(System.in);
    String answ;
    int answInt;
    int accNum=0;
    int cash=0;
    ArrayList<User> arrU = new ArrayList<User>(); // Create an ArrayList object
    ArrayList<Account> arrA = new ArrayList<Account>();
    User dummy = new User("Dummy",0,0);
    Account newAccount = new Account(dummy,0);
    public TheBank() {
    }
    public void start() {
        while(true) {
            System.out.println("Add user (press 1)");
            System.out.println("Add account (press 2)");
            System.out.println("Transaction (press 3)");
            System.out.println("View user transaction history (press 4)");
            System.out.println("Edit account information (press 5)");
            System.out.println();
            System.out.println("Current number of users: " + (accNum));
            System.out.println("Cash in the bank:" +  cash);
            System.out.println();
            System.out.println("End (press 0)");
            System.out.println();
            answ = inLine.next();
            if (answ.equals("1")) {
                newUser();
                accNum++;
            }
            if (answ.equals("2")) {
                newAccount();
            }
            if (answ.equals("3")) {
                transaction();
            }
            if (answ.equals("4")) {
                history();
            }
            if(answ.equals("5")){
                editUser();
            }
            if (answ.equals("0")) {
                break;
            }
        }
    }
    public void newUser(){
        User newUser = new User("Steve", 5,accNum);
        System.out.println("What's the new users name?");
        answ = inLine.next();
        newUser.name=answ;
        System.out.println("What's the users social credits number?");
        answInt=inLine.nextInt();
        newUser.social=answInt;
        arrU.add(newUser);
        newAccount.owner=dummy;
        arrA.add(newAccount);

        (arrU.get(accNum)).getUser();
        System.out.println("_______________________");
    }
    public void newAccount(){
        System.out.println("Which user is this account tied to? Enter social security number.");
        answInt = inLine.nextInt();
        for(int i=0; i<accNum;i++){
            if((arrU.get(i)).getSocial()==answInt){
                answInt=i;
                break;
            }
        }
        if((arrU.get(answInt)).hasAccount==true){
            System.out.println("This user already has an account. You cannot have several.");
            System.out.println();
        }
        else {
            newAccount.owner=(arrU.get(answInt));

            (arrU.get((answInt))).getUser();
            (arrA.get((answInt))).getAccount();
            System.out.println("_______________________");
            (arrU.get(answInt)).accountGot();
        }
    }
    public void transaction(){
        System.out.println("Which account? Enter social security number.");
        answInt = inLine.nextInt();
        for(int i=0; i<accNum;i++){
            if((arrU.get(i)).getSocial()==answInt){
                answInt=i;
                break;
            }
        }
        (arrA.get(answInt)).transaction();
        cash=cash+(arrA.get(answInt)).amount;
    }
    public void editUser(){
        System.out.println("Which user would you like to edit? Enter social security number.");
        answInt = inLine.nextInt();
        for(int i=0; i<accNum;i++){
            if((arrU.get(i)).getSocial()==answInt){
                answInt=i;
                break;
            }
        }
        (arrU.get(answInt)).editUser();
    }
    public void history(){
        Account aAcc;
        System.out.println("Whose history would you like to see? Enter social security number.");
        answInt = inLine.nextInt();
        for(int i=0; i<accNum;i++){
            if((arrU.get(i)).getSocial()==answInt){
                answInt=i;
                aAcc= arrA.get(i);
                try{
                    aAcc.list();
                }catch(Exception e){
                    System.out.println("no can do");
                }
                break;
            }
        }
    }
}