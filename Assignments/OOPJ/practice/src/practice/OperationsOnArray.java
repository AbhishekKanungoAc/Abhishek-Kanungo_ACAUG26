package practice;

public class OperationsOnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 2) Accept n integers into an array and display:  all prime numbers  largest
		 * number  second-largest number.
		 */
		System.out.println("++++++++++++++++++++++++Print Array+++++++++++++++++++++++++++");
		int[] arr = { 1, 56, 29, 22, 15, 96, 35, 42 };
			for (int i = 0; i < arr.length; i++) {
				System.out.print(" " + arr[i]); }
			System.out.println();
		System.out.println("++++++++++++++++++++++++++Even num in array+++++++++++++++++++++++++");
		
		for (int i = 0; i < arr.length; i++) {
			

			int count = 0;

			for (int j = 1; j <=arr[i]; j++) {
				if (arr[i] % j == 0) {
					count++;
				}
			}
			
			if(count == 2) {
				System.out.println(arr[i]);
			}

		}
		System.out.println("+++++++++++++++++++++Largest Element in array++++++++++++++++++++++++++++++"); 
		int MAX = arr[0];
		for(int i=0;i<arr.length;i++) {
			    if(arr[i]>MAX) {
			    	MAX = arr[i];
			    }
		}
		System.out.println(MAX);
		
		System.out.println("+++++++++++++++++++++++++Second Largest in Array++++++++++++++++++++++++++");
		
		int SecondLargest= arr[0];
		for(int i=1;i<arr.length;i++) {
			    if(arr[i]>MAX) {
			    	SecondLargest =MAX;
			    	MAX = arr[i];
			    }
		else if (arr[i] > SecondLargest && arr[i] != MAX) {
	        SecondLargest = arr[i];
	    }}
		System.out.println(SecondLargest);

	}

}
