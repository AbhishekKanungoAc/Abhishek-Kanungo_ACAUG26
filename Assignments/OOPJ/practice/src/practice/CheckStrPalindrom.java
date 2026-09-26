package practice;

public class CheckStrPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str= "mada1";
		String rev = "";
		String or = str;
		
		for(int i = str.length()-1;i>=0;i--) {
			rev = rev+ str.charAt(i);
		}
		
	if(or .equals(rev))
		System.out.println("Pallindrom");
	else
		System.out.println("Not a palindrom");
	}

}
