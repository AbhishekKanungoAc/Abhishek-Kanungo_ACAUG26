
public class Pattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 6. Using for loops write a program to display the following pattern
			1
			2 3
			4 5 6
			7 8 9 10
		 */
			System.out.println("Question number: 6 ");
			int num = 1;
			for (int iTemp=1;iTemp<=4;iTemp++ ) {
				
				for (int jTemp = 1; jTemp <= iTemp; jTemp++) { 
					
					System.out.print(num);
					num++;
					
					}
				System.out.println();
				}
			

	}

}
