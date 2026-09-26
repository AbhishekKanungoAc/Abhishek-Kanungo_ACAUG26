package practice;

import java.util.Scanner;

public class AmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to checks amstrong number: ");
		int num = sc.nextInt();
		int original = num;
		int sum = 0;

		while (num > 0) {
			int digit = num % 10;
			sum = sum + digit * digit * digit;
			num = num / 10;
		}

		if (original == sum)
			System.out.println("Amstrong number");
		else
			System.out.println("Not an amstrong number");
		sc.close();

	}

}
