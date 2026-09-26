package practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

class Transaction {

	int txId;
	LocalDate txDate;
	float txAmount;
	boolean txStatus;
	boolean txArrears;

	// Constructor
	Transaction(int txId, LocalDate txDate, float txAmount, boolean txStatus, boolean txArrears) {

		this.txId = txId;
		this.txDate = txDate;
		this.txAmount = txAmount;
		this.txStatus = txStatus;
		this.txArrears = txArrears;
	}

	// Display transaction
	void display() {
		System.out.println("ID: " + txId + ", Date: " + txDate + ", Amount: " + txAmount + ", Status: " + txStatus
				+ ", Arrears: " + txArrears);
	}
}

public class TransactionDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Collection to store Transaction objects
		ArrayList<Transaction> transactions = new ArrayList<>();

		// Taking 5 transactions from user
		for (int i = 1; i <= 5; i++) {

			System.out.println("\nEnter Transaction " + i);

			System.out.print("Transaction ID: ");
			int id = sc.nextInt();

			System.out.print("Transaction Date (yyyy-mm-dd): ");
			LocalDate date = LocalDate.parse(sc.next());

			System.out.print("Transaction Amount: ");
			float amount = sc.nextFloat();

			System.out.print("Transaction Status (true/false): ");
			boolean status = sc.nextBoolean();

			System.out.print("Transaction Arrears (true/false): ");
			boolean arrears = sc.nextBoolean();

			// Create object
			Transaction t = new Transaction(id, date, amount, status, arrears);

			// Store object in ArrayList
			transactions.add(t);
		}

		// ------------------------------------------------
		// 1. Transactions where txAmount > 5000
		// ------------------------------------------------

		Predicate<Transaction> amountCheck = t -> t.txAmount > 5000;

		System.out.println("\nTransactions where Amount > 5000:");

		for (Transaction t : transactions) {

			if (amountCheck.test(t)) {
				t.display();
			}
		}

		// ------------------------------------------------
		// 2. Transactions where txStatus is false
		// ------------------------------------------------

		Predicate<Transaction> statusCheck = t -> t.txStatus == false;

		System.out.println("\nTransactions where Status is false:");

		for (Transaction t : transactions) {

			if (statusCheck.test(t)) {
				t.display();
			}
		}

		// ------------------------------------------------
		// 3. Generate Amount Due
		// ------------------------------------------------

		Function<Transaction, Float> amountDue = t -> {

			if (t.txArrears) {

				// Amount + 500 + 18% of amount
				return t.txAmount + 500 + (t.txAmount * 18 / 100);

			} else {

				// Only transaction amount
				return t.txAmount;
			}
		};

		System.out.println("\nAmount Due:");

		for (Transaction t : transactions) {

			float due = amountDue.apply(t);

			System.out.println("Transaction ID: " + t.txId + " | Amount Due: " + due);
		}

		sc.close();
	}
}

/*
 * 
 * Create the following using Lambda and Collection Framework
 * 
 * Create a class called Transaction that contains the following data members 1.
 * txId int 2. txDate LocalDate 3. txAmount float 4. txStatus boolean 5.
 * txArrears boolean
 * 
 * Create 5 objects of the above Transaction object by taking input from the
 * user and store the same in a Collection object.
 * 
 * 
 * Create the Lambda expressions for 1. Getting all the Transactions from the
 * Collection where the txAmount is > 5000
 * 
 * 2. Getting all the Transactions where the txStatus is false
 * 
 * 3. Write a Lambda Function to generate the amount due. The amount due is
 * calculated as the txAmount + Rs. 500/- + 18% of txAmount if the txArrears is
 * true else if txArrears if false then only the txAmount will be returned
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */