package practice;

public class CheckPalindromInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {121,363,56,89,25,111,202,898};
		
		
		for(int i=0;i<arr.length;i++) {
			int num = arr[i];
			int or = num;
			int rev =0;
			while(num !=0) {
				int digit = num%10;
				rev = rev*10+digit;
				num /= 10;
				
			}
			if(rev == or) 
				System.out.println(rev+ " Number is pallindrom");
			
			else
				System.out.println(rev+ " Number is not pallindrom");
			
		}
		

		

	}

}
