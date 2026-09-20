
public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		4. Write a Java program to get the index of all the characters of the alphabet.  
Sample Output:
a  b c  d e  f  g h i  j                                                                                     
=========================                                                                                     
36 10 7 40 2 16 42 1 6 20                                                                                     
                                                                                                   
k  l  m  n  o  p q  r  s  t                                                                                   
===========================                                                                                   
8 35 22 14 12 23 4 11 24 31                                                                                   

u  v  w  x  y  z                                                                                              
================                                                                                              
5 27 13 18 38 37
Sample string of all alphabet: "The quick brown fox jumps over the lazy dog."
				
		*/	
		System.out.println("Enter the string1:");
		String s = ConsoleInput.getString();
		
		//int v = 97;
		for(int i =97; i<123;i++) {
			char c = (char)i;
			System.out.print(c+"  ");	
		}
		System.out.println(" ");
		System.out.println("==================================================");
		
		for(char c = 'a'; c<='z';c++) {
			System.out.print(s.indexOf(c)+" ");
		}
		
		/*
		 * for(char c = 'a'; c<='z';c++) { System.out.print(c+" ==> "+s.indexOf(c)+" ");
		 * }
		 */
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
