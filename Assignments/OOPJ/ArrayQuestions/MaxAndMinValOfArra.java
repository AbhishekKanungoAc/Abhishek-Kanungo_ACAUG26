
public class MaxAndMinValOfArra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Modify exercise 2 Write a Java program to find the maximum and minimum value of an array
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
		int max = arr[0];
		int min = arr[0];
		for(int iTemp=1; iTemp<arr.length;iTemp++) {
			if(max < arr[iTemp]) {
				max = arr[iTemp];
			}
			
			if(min > arr[iTemp]) {
				min = arr[iTemp];
			}
			
			
		}
		System.out.println("maximum Ele in array is: "+max);
		System.out.println("minimun Ele in array is: "+min);
		
		

	}

}
