
public class Pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 7. Using for loops write a program to display the following pattern
		1
		1 2
		1 2 3
		1 2 3 4
		1 2 3 4 5
		1 2 3 4 5 6

		 */
			System.out.println("Question number: 7 ");
			
			for (int iTemp=1;iTemp<=6;iTemp++ ) {
				int num1 = 1;
				for (int jTemp = 1; jTemp <= iTemp; jTemp++) { 
					
					System.out.print(num1);
					num1++;
					
					}
				System.out.println();
				}
			

	}

}
