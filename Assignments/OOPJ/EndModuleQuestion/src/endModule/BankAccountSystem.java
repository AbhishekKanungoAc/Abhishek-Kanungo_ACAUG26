package endModule;

import java.util.Scanner;

// Custom Exception
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException() {
        super("Withdrawal denied due to insufficient balance");
    }
}

// Base Class
class Account {

    protected int accountNumber;
    protected double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException();
        }

        balance = balance - amount;
    }

    public double getBalance() {
        return balance;
    }
}

// Savings Account
class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException {

        // Minimum balance must be 500
        if (balance - amount < 500) {
            throw new InsufficientBalanceException();
        }

        balance = balance - amount;
    }
}

// Current Account
class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException {

        // Balance must not become negative
        if (amount > balance) {
            throw new InsufficientBalanceException();
        }

        balance = balance - amount;
    }
}

// Main Class
public class BankAccountSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter account type: ");
            String accountType = sc.nextLine();

            System.out.print("Enter account number: ");
            int accountNumber = sc.nextInt();

            System.out.print("Enter balance: ");
            double balance = sc.nextDouble();

            System.out.print("Enter withdrawal amount: ");
            double withdrawAmount = sc.nextDouble();

            // Parent reference
            Account account;

            // Polymorphism
            if (accountType.equalsIgnoreCase("savings")) {

                account = new SavingsAccount(
                        accountNumber,
                        balance
                );

            } else if (accountType.equalsIgnoreCase("current")) {

                account = new CurrentAccount(
                        accountNumber,
                        balance
                );

            } else {

                System.out.println("Invalid account type.");
                return;
            }

            // Runtime polymorphism
            account.withdraw(withdrawAmount);

            System.out.println("Withdrawal successful");
            System.out.println(
                    "Remaining Balance = " + account.getBalance()
            );

        } catch (InsufficientBalanceException e) {

            System.out.println(
                    "Withdrawal denied due to insufficient balance"
            );

        } finally {

            sc.close();
        }
    }
}

