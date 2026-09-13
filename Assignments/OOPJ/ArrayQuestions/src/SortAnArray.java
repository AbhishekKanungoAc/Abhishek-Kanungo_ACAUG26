
public class SortAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Write a Java program to sort an numeric array. The size of the array will be
		 * taken from the user, after he specifies the size all the elements of the array
		 * will be taken as input and the array will be sorted.
		 */
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
		
		
		
		

	}

}
