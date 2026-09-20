
public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*5. Write a Java program to replace each substring of a given string that matches the given regular expression with the given replacement.  
Sample string : "The quick brown fox jumps over the lazy dog."
In the above string replace all the fox with cat.
Sample Output:
Original string: The quick brown fox jumps over the lazy dog.                                                 
New String: The quick brown cat jumps over the lazy dog.


6. Write a Java program to convert all the characters in a string to uppercase. 
 Sample Output:
Original String: The Quick BroWn FoX!                                                                         
String in uppercase: THE QUICK BROWN FOX! 


7. Write a Java program to reverse a string.
Sample Output:
The given string is: The quick brown fox jumps
The string in reverse order is:
spmuj xof nworb kciuq ehT

				*/
		System.out.println("Enter the string:");
		String s = ConsoleInput.getString();
		
		System.out.println("Original string: "+s);
		
		
		
		System.out.println("New string: "+s.replace("fox", "cat"));
		
		System.out.println("To uppercase: "+s.toUpperCase());
		
		String revers = "";
		for(int i=s.length()-1; i>=0; i--) {
			revers += s.charAt(i);
		}
		System.out.print("revers order: "+revers);
		
	}

}
