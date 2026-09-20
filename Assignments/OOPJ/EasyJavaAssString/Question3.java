
public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 3. Write a Java program to check whether a given string ends with the contents of another string.  
			 Sample Output:
			"Python Exercises" ends with "se"? false                                                                      
			"Python Exercise" ends with "se"? true
			*/
		System.out.println("Enter the string1:");
		String s1 = ConsoleInput.getString();
		System.out.println("Enter the string2:");
		String s2 = ConsoleInput.getString();
		
		
		boolean b  = s1.endsWith(s2);
        System.out.println("\"" + s1 + "\" ends with \"" + s2 + "\"? " + b);
		
		
	}

}
