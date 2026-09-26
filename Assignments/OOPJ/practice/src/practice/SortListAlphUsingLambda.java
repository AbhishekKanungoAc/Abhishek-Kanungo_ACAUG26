package practice;

import java.util.ArrayList;
import java.util.Arrays;

/*

Given a list of names, Lambda expression ka use karke names ko alphabetical order mein sort karke print karo.

Input:

["Rahul", "Amit", "Vijay", "Neha", "Priya"]
Amit
Neha
Priya
Rahul
Vijay
*/
public class SortListAlphUsingLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <String> names = new ArrayList<>();
		names.add("Ragul");
		names.add("Amit");
		names.add("Vijay");
		names.add("Abhi");
		names.add("Priya");
		
		names.sort((a,b)-> a.compareToIgnoreCase(b));
		
		System.out.println(names);

	}

}
