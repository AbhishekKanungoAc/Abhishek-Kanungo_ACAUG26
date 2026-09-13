
public class ReversAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Modify exercise 2 Write a Java program to reverse an array of integer values
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
		System.out.println("Revers Array: ");
		for(int iTemp=arr.length-1; iTemp>=0;iTemp--) {
			System.out.print(arr[iTemp]+" ");
		}

	}

}
