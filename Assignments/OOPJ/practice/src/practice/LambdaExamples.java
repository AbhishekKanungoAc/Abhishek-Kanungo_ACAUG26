package practice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
Using existing (pre-defined) Functional Interfaces in Java write,

1. Lambda expression to sort a string array in alphabetical order
2. Lambda expression to find the largest number in an integer array.
3. Lambda expression to find the smallest number in an integer array.
4. Lambda expression to generate a 3 digit random number
5. Lambda expression that takes an integer array and returns the reverse integer array
6. Lambda expression to print the current date
7. Lambda expression to evaluate if a number entered is a Prime number
8. Lambda expression to accept 2 strings and return the concatenated value of the sam

*/
public class LambdaExamples {

	public static void main(String[] args) {

		// --------------------------------------------------
		// 1. Sort String array in alphabetical order
		// --------------------------------------------------

		String[] names = { "Rohit", "Amit", "Zoya", "Karan", "Neha" };

		Consumer<String[]> sortArray = arr -> Arrays.sort(arr);

		sortArray.accept(names);

		System.out.println("1. Sorted Array:");
		System.out.println(Arrays.toString(names));

		// --------------------------------------------------
		// 2. Find largest number
		// --------------------------------------------------

		int[] numbers = { 10, 45, 23, 89, 12, 67 };

		Function<int[], Integer> largest = arr -> {
			int max = arr[0];

			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > max) {
					max = arr[i];
				}
			}

			return max;
		};

		System.out.println("\n2. Largest Number: " + largest.apply(numbers));

		// --------------------------------------------------
		// 3. Find smallest number
		// --------------------------------------------------

		Function<int[], Integer> smallest = arr -> {
			int min = arr[0];

			for (int i = 1; i < arr.length; i++) {
				if (arr[i] < min) {
					min = arr[i];
				}
			}

			return min;
		};

		System.out.println("3. Smallest Number: " + smallest.apply(numbers));

		// --------------------------------------------------
		// 4. Generate 3 digit random number
		// --------------------------------------------------

		Supplier<Integer> randomNumber = () -> new Random().nextInt(900) + 100;

		System.out.println("4. Random 3 Digit Number: " + randomNumber.get());

		// --------------------------------------------------
		// 5. Reverse integer array
		// --------------------------------------------------

		Function<int[], int[]> reverseArray = arr -> {
			int[] reverse = new int[arr.length];

			for (int i = 0; i < arr.length; i++) {
				reverse[i] = arr[arr.length - 1 - i];
			}

			return reverse;
		};

		int[] reversed = reverseArray.apply(numbers);

		System.out.println("5. Reverse Array:");
		System.out.println(Arrays.toString(reversed));

		// --------------------------------------------------
		// 6. Print current date
		// --------------------------------------------------

		Supplier<LocalDate> currentDate = () -> LocalDate.now();

		System.out.println("6. Current Date: " + currentDate.get());

		// --------------------------------------------------
		// 7. Check Prime Number
		// --------------------------------------------------

		Predicate<Integer> isPrime = number -> {

			if (number < 2) {
				return false;
			}

			for (int i = 2; i <= Math.sqrt(number); i++) {

				if (number % i == 0) {
					return false;
				}
			}

			return true;
		};

		int num = 17;

		System.out.println("7. Is " + num + " Prime? " + isPrime.test(num));

		// --------------------------------------------------
		// 8. Concatenate two strings
		// --------------------------------------------------

		BiFunction<String, String, String> concatenate = (str1, str2) -> str1 + str2;

		System.out.println("8. Concatenated String: " + concatenate.apply("Hello ", "Java"));
	}
}