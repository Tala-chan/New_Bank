import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class Account {
    Scanner inLine = new Scanner(System.in);
    User owner;
    int balance;
    int amount;
    public Account(User owner, int balanace){
        this.owner=owner;
        this.balance=balance;
    }
    public void transaction(){
        System.out.println("How much did you get paid/spend? (Positive number for payment, negative number for spending)");
        amount=(inLine.nextInt());
        balance=balance+amount;
        System.out.println();
        getAccount();
    }
    public void getAccount(){
        System.out.println("Balance: " + balance);
    }
    public void list() {
    }

}
