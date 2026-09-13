
class ComplexN{
	private int Num1 ;
	private int Num2 ;
	public int getNum1() {
		return Num1;
	}
	public void setNum1(int num1) {
		Num1 = num1;
	}
	public int getNum2() {
		return Num2;
	}
	public void setNum2(int num2) {
		Num2 = num2;
	}
	
	public int computeComplexNumber() {
		
		return Num1*Num2;
		
	}
	
	
	
	
	
}


public class ComplexNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * create a class called ComplexNumber having 2 data members as number1 and
		 * number2. Create a pair of ge-er and se-er for the above. Create a method
		 * called computeComplexNumber that will mul&ply the values of the 2 data
		 * members and return it in the form of int. For the above create an array of
		 * ComplexNumber having 5 elements and in a loop ask the user to enter number1
		 * and number2 5 num each such that each object of the ComplexNumber hold
		 * appropriate values. Finally call the computeComplexNumber on each object of
		 * the array to display the result.
		 */
		ComplexN[] ArryOfObj = new ComplexN[5];
		
		for(int iTemp=0; iTemp<5; iTemp++) {
			ArryOfObj[iTemp] = new ComplexN();
			
			System.out.println("Enter the Numbers for Object "+ (iTemp+1));
			System.out.println("Enter the Num1: ");
			int n1 = ConsoleInput.getInt();
			
			System.out.println("Enter the Num2: ");
			int n2 = ConsoleInput.getInt();
			
			ArryOfObj[iTemp].setNum1(n1);
			ArryOfObj[iTemp].setNum2(n2);
		
		}
		
		System.out.println("\nResults ");
		for(int iTemp=0; iTemp<5; iTemp++) {
			
			   int result = ArryOfObj[iTemp].computeComplexNumber();

	            System.out.println(
	                "Object " + (iTemp + 1) +
	                " Result = " + result );
			
		}
		
		
		
		
	
	}

}
