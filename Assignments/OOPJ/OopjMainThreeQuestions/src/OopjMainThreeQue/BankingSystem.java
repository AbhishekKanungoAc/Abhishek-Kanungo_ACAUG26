package OopjMainThreeQue;


import java.util.Scanner;


//Custom Exception
class InsufficientBalanceException extends Exception {

 InsufficientBalanceException(String message) {
     super(message);
 }
}


//Interface
interface BankAccount {

 void deposit(double amount);

 void withdraw(double amount)
     throws InsufficientBalanceException;

 void displayBalance();
}


//Savings Account
class SavingsAccount implements BankAccount {

 private int accountNumber;
 private double balance;

 SavingsAccount(int accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }


 @Override
 public void deposit(double amount) {

     balance = balance + amount;

     System.out.println(
         "Amount deposited successfully."
     );
 }


 @Override
 public void withdraw(double amount)
     throws InsufficientBalanceException {

     if (balance - amount < 1000) {

         throw new InsufficientBalanceException(
             "Minimum balance of Rs.1000 required"
         );
     }

     balance = balance - amount;

     System.out.println(
         "Amount withdrawn successfully."
     );
 }


 @Override
 public void displayBalance() {

     System.out.println(
         "Savings Account Balance: " + balance
     );
 }
}


//Current Account
class CurrentAccount implements BankAccount {

 private int accountNumber;
 private double balance;

 CurrentAccount(int accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }


 @Override
 public void deposit(double amount) {

     balance = balance + amount;

     System.out.println(
         "Amount deposited successfully."
     );
 }


 @Override
 public void withdraw(double amount)
     throws InsufficientBalanceException {

     if (balance - amount < 5000) {

         throw new InsufficientBalanceException(
             "Minimum balance of Rs.5000 required"
         );
     }

     balance = balance - amount;

     System.out.println(
         "Amount withdrawn successfully."
     );
 }


 @Override
 public void displayBalance() {

     System.out.println(
         "Current Account Balance: " + balance
     );
 }
}


//Main class
public class BankingSystem {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     // Runtime polymorphism
     BankAccount account;

     System.out.println("1. Savings Account");
     System.out.println("2. Current Account");

     System.out.print("Enter choice: ");
     int choice = sc.nextInt();


     if (choice == 1) {

         account = new SavingsAccount(
             101,
             10000
         );

     } else {

         account = new CurrentAccount(
             102,
             20000
         );
     }


     account.displayBalance();


     System.out.print("Enter deposit amount: ");
     double deposit = sc.nextDouble();

     account.deposit(deposit);

     account.displayBalance();


     System.out.print("Enter withdrawal amount: ");
     double withdraw = sc.nextDouble();


     try {

         account.withdraw(withdraw);

     } catch (InsufficientBalanceException e) {

         System.out.println(
             "InsufficientBalanceException: "
             + e.getMessage()
         );
     }


     account.displayBalance();

     sc.close();
 }
}