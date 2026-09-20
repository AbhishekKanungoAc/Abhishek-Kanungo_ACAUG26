
public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 2. Write a Java program to compare two strings lexicographically. 
		 * Two strings are lexicographically equal if they are the same length and 
		 * contain the same number of characters in the same positions.  
		Sample Output:
		String 1: This is Exercise 1                                                                                  
		String 2: This is Exercise 2                                                                                  
		"This is Exercise 1" is less than "This is Exercise 2"
				*/
		System.out.println("Enter the string1:");
		String s1 = ConsoleInput.getString();
		System.out.println("Enter the string2:");
		String s2 = ConsoleInput.getString();
		
		if(s1.compareTo(s2)<0) {
			System.out.println(s1+" is less than "+s2);
		}else if(s1.compareTo(s2)>0) {
			System.out.println(s1+" is greater than "+s2);
		}else {
			System.out.println(s1+" is equal "+s2);
		}
		
		
	}

}
