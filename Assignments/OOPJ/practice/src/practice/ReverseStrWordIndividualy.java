package practice;

public class ReverseStrWordIndividualy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3) Accept a sentence and reverse every word individually.
		//Example:
			//Input : Java is easy
			//Output : avaJ si ysae

		String name = "Java is easy";
		
		String []arr = name.split(" ");
		
		for(int i=0;i<arr.length;i++) {
		String word = arr[i];
		
			for (int j=word.length()-1;j>=0;j--) {
				System.out.print(word.charAt(j));
			}
			System.out.print(" ");
		}
		
		
	}

}
