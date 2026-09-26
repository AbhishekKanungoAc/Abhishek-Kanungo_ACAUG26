package ArrayListQuestions;
import java.util.Collections;
import java.util.ArrayList;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 1. Write a Java program to create a new array list, add some colors (string)
		 * and print out the collection. 2. Modify the above Java program to insert an
		 * element into the array list at the first position. 3. Modify the above Java
		 * program to retrieve an element (at a specified index) from a given array
		 * list. 4. Modify the above Java program to update specific array element by
		 * given element.? 5. Modify the above Java program to remove the third element
		 * from a array list. 6. Modify the above Java program to search an element in a
		 * array list
		 */
		System.out.println("1. created arraylist And Print");
		ArrayList<String> colors = new ArrayList<>();
		colors.add("Blue");
		colors.add("Orange");
		colors.add("Yellow");
		colors.add("Green");
		colors.add("Black");

		System.out.println(colors);
		System.out.println("==================================================================");
		System.out.println("2. Inserted element at first index: ");
		colors.add(0, "White");
		System.out.println(colors);
		System.out.println("==================================================================");
		System.out.println("3. retrieve an element at a specified index: ");
		System.out.println(colors.get(2));
		System.out.println("==================================================================");
		System.out.println("4. update an element with specified element: ");
		colors.set(colors.indexOf("Blue"), "WhiteBlue");
		System.out.println(colors);
		System.out.println("==================================================================");
		System.out.println("5. remove 3 element: ");
		colors.remove(3);
		System.out.println(colors);
		System.out.println("==================================================================");
		System.out.println("6. search or check element: ");
		System.out.println(colors.contains("Black"));
		
		
		System.out.println("==================================================================");
		/*		
				7. Modify the above Java program to sort a given array list. (Hint : Use the class Collections)
8. Modify the above Java program to copy one array list into another. (Hint : Use the class Collections)
9. Modify the above Java program to shuffle elements in a array list. (Hint : Use the class Collections)
10. Modify the above Java program to reverse elements in a array list. (Hint : Use the class Collections)

				
				
		*/
		System.out.println("7. Sorted arraylist: ");
		Collections.sort(colors);
		System.out.println(colors);
		System.out.println("==================================================================");
		System.out.println("8. copy one arraylist to another: ");	
		ArrayList<String> rainbow = new ArrayList<>();
		rainbow.add("green");
		rainbow.add("green");
		rainbow.add("green");
		rainbow.add("green");
		rainbow.add("green");
		Collections.copy(rainbow,colors );
		System.out.println(rainbow);
		System.out.println("==================================================================");
		System.out.println("9. shuffule elements: ");
		
		Collections.shuffle(rainbow);
		System.out.println(rainbow);
		System.out.println("==================================================================");
		System.out.println("10. revers elements: ");
		Collections.reverse(rainbow);
		System.out.println(rainbow);
		
		
		
	}

}
