package Practiesproblems;

import java.util.*;

public class StackThroughArray {
	int arr[];
	int capacity;
	int top;

	public StackThroughArray(int c) {
		// TODO Auto-generated constructor stub
		capacity = c;
		arr = new int[capacity];
		top = -1;
	}

	public void push(int n) {
		if (top == capacity - 1) {
			System.out.println("Stack Overflow");
			return;
		}

		arr[++top] = n;

	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack empty");
			return -1;
		}
		return arr[top--];
	}
	public void display() {
	    if (top == -1) {
	        isEmpty();
	    }

	    System.out.println("Stack:");

	    for (int i = top; i >= 0; i--) {
	        System.out.println(arr[i]);
	    }
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the capacity of stack: ");
		int c = sc.nextInt();
		StackThroughArray st = new StackThroughArray(c);

		int choice;

		do {
			System.out.println("=====Menu====");
			System.out.println("1. Add Element");
			System.out.println("2. Display All Element");
			System.out.println("3. Pop");
			System.out.println("4. Check stack isEmpty?");
			System.out.println("5. Check stack isEmpty?");
			System.out.println("6. Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("How many Elemants you want to push:  ");
				int NoE = sc.nextInt();
				if(NoE == c) {
				System.out.println("Enter the elements: ");
				for(int i=0;i<c;i++) {
				int n = sc.nextInt();
				st.push(n);}
				System.out.println("Elements Push to Stack");
				}else {
					System.out.println("It Reachs the capacity of stack!");
				}
				break;
			case 2:
				st.display();
				break;
			case 3:
				System.out.println("Top Element " + st.pop() + " Poped.");
				break;
			case 4:
				System.out.println(st.isEmpty());

				break;
			case 5:
				System.out.println(st.isFull());
				break;
			case 6:
				System.out.println("Exiting.... ");
				break;
			default:
				System.out.println("Invalide choice");
				break;
			}

		} while (choice != 6);

	}

}
