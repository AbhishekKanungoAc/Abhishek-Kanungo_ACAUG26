package practice;

public class CheckPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num =123;
		boolean prime = true;
		
		
		if(num<=1) {
		prime = false;	
		}
		
		for(int i=2;i<num;i++) {
			if(num%i == 0) {
				prime =false;
			}
		}
		
		System.out.println("Number is Prime: "+prime);
		
		
	}

}
