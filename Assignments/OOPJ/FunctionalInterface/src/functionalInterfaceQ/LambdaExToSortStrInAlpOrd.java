package functionalInterfaceQ;


import java.util.Arrays;



public class LambdaExToSortStrInAlpOrd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Using existing (pre-defined) Functional Interfaces in Java write,
		//1. Lambda expression to sort a string array in alphabetical order

		
		String []arr = {"mbhi","Abhya","manoj","raj"};
		Arrays.sort(arr, (s1, s2) -> s1.compareTo(s2));
		
		 System.out.println(Arrays.toString(arr));
	

	}

}
