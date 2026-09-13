
public class Pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 4. Using For loops write a program to display the following pattern
		 *
		 **
		 ***
		 ****
		 *****
		 */
			System.out.println("Question number: 4 ");
			for (int iTemp=1;iTemp<=5;iTemp++ ) {
				for (int jTemp = 1; jTemp <= iTemp; jTemp++) { 
					System.out.print("*"); 
					}
				System.out.println();
				}
	}

}
