
public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Write a Java program to get the character at the given index within the String. 
		/*
		 * Original String = Java Exercises! 
		 * The character at position 0 is J 
		 * The character at position 10 is i
		 */
		System.out.println("Enter the string:");
		String s = ConsoleInput.getString();
		
		System.out.println("Original String = "+s);
		int i = 1;
		do {
		System.out.println("Enter the character postion: ");
		int p = ConsoleInput.getInt();
		for(int iTemp=0;iTemp<s.length();iTemp++) {
			if(p == iTemp) {
				System.out.println("The character at position "+p+" is "+ s.charAt(iTemp));
				
			}
			
		}
		i++;
		}while(i<=2);
		
		

	}

}
