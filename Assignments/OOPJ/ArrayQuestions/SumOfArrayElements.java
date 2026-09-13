
public class SumOfArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Modify the exercise 2 and Write a Java program to sum values of an array
		
		System.out.println("Enter the Size of array: ");
		int size = ConsoleInput.getInt();
		
		int arr[] = new int[size];
		System.out.println("Enter the "+size+" elements in array: ");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			arr[iTemp]=ConsoleInput.getInt();
			//System.out.print(iTemp+" ");
		}
		System.out.println("Array Befor Sorting: ");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			System.out.print(arr[iTemp]+" ");
		}
		
		System.out.println();
		//sorting logic
		System.out.println("Array After Sorting: ");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			for (int j = 0; j < arr.length - 1 - iTemp; j++) { 
				if (arr[j] > arr[j + 1]) 
				{ int temp = arr[j]; 
				arr[j] = arr[j + 1]; 
				arr[j + 1] = temp; } }
			}
		
		for (int iTemp = 0; iTemp < arr.length; iTemp++) {
			System.out.print(arr[iTemp] + " "); 
			}
		System.out.println();
		//sum of array elements
		System.out.print("sum of array elements: ");
		int sum =0;
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			
			sum = sum + arr[iTemp];
			
			}
		System.out.print(sum);
		
		
		

	}

}
