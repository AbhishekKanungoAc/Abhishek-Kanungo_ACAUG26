
public class MatchArrayEle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Modify exercise 2 to accept 2 different values in 2 different arrays and find the common elements between two arrays
		System.out.println("Enter the Size of array: ");
		int size = ConsoleInput.getInt();
		
		int arr[] = new int[size];
		System.out.println("Enter the "+size+" elements in array one: ");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			arr[iTemp]=ConsoleInput.getInt();
			//System.out.print(iTemp+" ");
		}
		
		int arr1[] = new int[size];
		System.out.println("Enter the "+size+" elements in array two: ");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			arr1[iTemp]=ConsoleInput.getInt();
			//System.out.print(iTemp+" ");
		}
		
		System.out.println("Array One: ");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			System.out.print(arr[iTemp]+" ");
		}
		System.out.println();
		System.out.println("Array Two: ");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			System.out.print(arr1[iTemp]+" ");
		}
		
		System.out.println();
		System.out.println("the common elements between two arrays: ");
		for(int iTemp=0; iTemp<arr.length;iTemp++) {
			for(int jTemp=0; jTemp<arr.length;jTemp++) {
				if(arr[iTemp]==arr1[jTemp]) {
					System.out.print(arr[iTemp]+" ");
				}
			}
		}
		
		
		
		
		

	}

}
