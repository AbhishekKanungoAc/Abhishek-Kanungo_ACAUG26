package assignmentOne;

import java.util.*;

/*
 * Question 1
Given an integer array, find the maximum and minimum elements in the array.
Example
Input: [15, 8, 23, 4, 19, 7]
Output: Maximum = 23
 Minimum = 4

Question 2
Given an integer array, find the second largest distinct element in the array.
Example
Input: [12, 5, 8, 20, 15, 20, 7]
Output: Second Largest = 15


*/
public class FindMaxAndMinNumInArray {

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
		int max = arr[0];
		int secmax = arr[0];
		int min = arr[0];

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > max) {
				secmax = max;
				max = arr[i];
			} else if (arr[i] > secmax && arr[i] != max) {
				secmax = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println();
		System.out.println("maximun ele is:  " + max);
		System.out.println("minimum ele is:  " + min);
		System.out.println("sec max ele is:  " + secmax);

	}

}
