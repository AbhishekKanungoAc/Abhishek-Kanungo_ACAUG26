package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Q3: Given a list of numbers, duplicate values remove karke print karo.

Input:

10, 20, 10, 30, 20, 40, 30

Expected:

10, 20, 30, 40



*/
public class RemoveDuplicateValuesUsingLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Integer> num = new ArrayList<>();
		num.add(10);
		num.add(20);
		num.add(10);
		num.add(30);
		num.add(20);
		num.add(40);
		num.add(30);
		System.out.println(num);
		
		Set<Integer> uniqueNumbers = new HashSet<>(num);
		System.out.println(uniqueNumbers);
		
		Set<Integer> uniqueNumbers1 = new LinkedHashSet<>(num);
		System.out.println(uniqueNumbers1);
		
		Set<Integer> uniqueNumbers2 = new TreeSet<>(num);
		System.out.println(uniqueNumbers2);


	}

}
