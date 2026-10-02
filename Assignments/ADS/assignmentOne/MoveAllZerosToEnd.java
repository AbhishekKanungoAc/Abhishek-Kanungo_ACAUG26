package assignmentOne;

import java.util.Scanner;

/*
Given an integer array, move all 0s to the end of the array while maintaining the relative
order of all non-zero elements.
Examples
Example 1
Input: [0, 5, 0, 3, 8, 0, 2]
Output: [5, 3, 8, 2, 0, 0, 0]
Example 2
Input: [4, 0, 5, 0, 2, 7]
Output: [4, 5, 2, 7, 0, 0]




*/
public class MoveAllZerosToEnd {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array:");
		int n = sc.nextInt();

		int arr[] = new int[n];
		System.out.println("Enter " + n + " Elements in array: ");
		for (int i = 0; i <= arr.length - 1; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int j = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				j++;
			}
		}

		System.out.println("Array after moving zero to end: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
