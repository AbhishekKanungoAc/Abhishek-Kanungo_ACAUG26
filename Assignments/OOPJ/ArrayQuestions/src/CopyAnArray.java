
public class CopyAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Modify exercise 2 Write a Java program to copy an array by itera&ng the array
		
		System.out.println("Enter the Size of array: ");
		int size = ConsoleInput.getInt();
		
		int arr[] = new int[size];
		System.out.println("Enter the "+size+" elements in array: ");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			arr[iTemp]=ConsoleInput.getInt();
			//System.out.print(iTemp+" ");
		}
		
		System.out.println("original Array: ");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			System.out.print(arr[iTemp]+" ");
		}
		System.out.println();
		
		int copyArray[] = new int[size];
		
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			copyArray[iTemp] = arr[iTemp];
		}
		
		System.out.println("Copy Array:");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			System.out.print(copyArray[iTemp]+" ");
		}
		

	}

}
