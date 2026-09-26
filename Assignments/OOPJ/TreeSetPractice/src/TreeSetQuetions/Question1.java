package TreeSetQuetions;

import java.util.Collections;
import java.util.TreeSet;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		11. Write a Java program to create a new tree set, add some colors (string) and print out the tree set.
		12. Modify the above Java program to add all the elements of a specified tree set to another tree set.
		13. Modify the above Java program to create a reverse order view of the elements contained in a given tree set.
		14. Modify the above Java program to get the first and last elements in a tree set.
		15. Write a Java program to get the element in a tree set which is greater than or equal to the given element. (Hint : Use the ceiling method of the TreeSet)
			*/
		
		
		TreeSet<String> color = new TreeSet<>();
		
		color.add("Black");
		color.add("White");
		color.add("Green");
		color.add("Red");
		color.add("Yellow");
		
		System.out.println(color);
		
		TreeSet<String> color1 = new TreeSet<>();
		color1.add("navy blue");
		color1.add("Grey");
		System.out.println(color1);
		
		color1.addAll(color);
		System.out.println(color1);
		
		System.out.println(color1.descendingSet());
		
		System.out.println("First ele: "+ color1.first());
		System.out.println("last ele: "+ color1.last());
		
		TreeSet<Integer> num = new TreeSet<>();
		num.add(10);
		num.add(20);
		num.add(30);
		num.add(50);
		
		int number = 26;
		Integer result = num.ceiling(number);
		
		
		System.out.println("element which is greater than or equal "+number+" is : "+result);
		
		
		
		
	}

}
