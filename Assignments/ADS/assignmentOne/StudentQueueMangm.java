package assignmentOne;

import java.util.ArrayList;
import java.util.Scanner;

/*

Implement the solution using ArrayList<Integer>. Create a menu-driven program such
as:
1. Add Student
2. Submit Assignment
3. Search Student
4. Display Queue
5. Count Students
6. Exit






Example
Initial queue: [105, 112, 108, 101, 115]
Student 105 submits.
Queue becomes: [112, 108, 101, 115]
Search:
 Enter Student ID: 101
 Output: Student 101 is waiting.
Current number of students: 4




*/
public class StudentQueueMangm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> que = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("=====Menu====");
			System.out.println("1. Add Student");
			System.out.println("2. Submit Assignment");
			System.out.println("3. Search Student");
			System.out.println("4. Display Queue");
			System.out.println("5. Count Students");
			System.out.println("6. Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter sId to add Student: ");
				int n = sc.nextInt();
				que.add(n);
				System.out.println("Student added successfuly");
				break;
			case 2:
				System.out.println("Student " + que.remove(0) + " submits.");
				break;
			case 3:
				System.out.println("Enter Student id : ");
				int id = sc.nextInt();
				if (que.contains(id))
					System.out.println("Student " + id + " is waiting.");
				else
					System.out.println("Student " + id + " not in queue.");
				break;
			case 4:
				System.out.println("Queue: " + que);
				break;
			case 5:
				System.out.println("Current number of students: " + que.size());
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
