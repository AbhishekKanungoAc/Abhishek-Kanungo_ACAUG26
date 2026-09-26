package functionalInterfaceQ;


interface MaxFinder{
	int find(int[]arr);
}

public class ToFindLargestAndSmallestWithLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2. Lambda expression to find the largest number in an integer array.
		//3. Lambda expression to find the smallest number in an integer array.
		

		int arr[] = {12,22,53,65,65,25,32,56,1};
		
		MaxFinder finder = (array)->{
			int max = array[0];
			for(int num:array) {
				if(num>max) {
					max =num;
				}
			}
			return max;
		};
		int largest = finder.find(arr);
		System.out.println("Largest: " + largest);
		
		System.out.println("==============================================");
		
		MaxFinder finderr = (array)->{
			int min = arr[0];
			for(int n : array) {
				if(n<min) {
					min = n;
				}
			}
			return min;
		};
		int smallest = finderr.find(arr);
		System.out.println("smallest: " + smallest);
		
		System.out.println("==============================================");
		
		
		
		
	}

}
