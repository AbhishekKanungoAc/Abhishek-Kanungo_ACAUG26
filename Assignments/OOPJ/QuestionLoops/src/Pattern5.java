
public class Pattern5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 8. Using for loops write a program to display the following pattern
		1 2 3 4 5 6
		1 2 3 4 5
		1 2 3 4 5
		1 2 3 4
		1 2 3 
		1 2 
		1
		 */
			System.out.println("Question number: 8 ");
			
			for (int iTemp=6;iTemp>=1;iTemp-- ) {
				int num1 = 1;
				for (int jTemp = 1; jTemp <= iTemp; jTemp++) { 
					
					System.out.print(num1);
					num1++;
					
					}
				System.out.println();
				}



	}

}
