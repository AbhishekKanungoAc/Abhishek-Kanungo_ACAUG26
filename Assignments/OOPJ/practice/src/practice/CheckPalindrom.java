package practice;

public class CheckPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num =14521;
		int or = num;
		int rev =0;
		while(num !=0) {
			int digit = num%10;
			rev = rev*10+digit;
			num /= 10;
			
		}
		
		if(rev == or) 
			System.out.println(rev+ " Numer is pallindrom");
		
		else
			System.out.println(rev+ " Numer is not pallindrom");
	}

}
