package functionalInterfaceQ;

import java.util.Arrays;

//5. Lambda expression that takes an integer array and returns the reverse integer array
interface ArrayReverse{
	int [] revers(int[]arr);
}

public class ReversArrayUsingLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []arr = {1,2,3,5,4,6};
		
		ArrayReverse revers =(array)->{ //lambda expre
			int [] rev = new int[array.length]; // rev for copying arr in it 
			for (int i = 0; i < array.length; i++) {
                rev[i] = array[array.length - 1 - i];}
            return rev;
		};
		 int[] result = revers.revers(arr); //Storing array revers in result arr
	        System.out.println(Arrays.toString(result)); // [6,5, 4, 3, 2, 1]
		
	}

}
