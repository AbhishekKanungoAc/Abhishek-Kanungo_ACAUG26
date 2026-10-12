package Practiesproblems;

public class TowerOFHenoi {

	static void tower(int n, char s,char d,char h) {
		if(n == 1) {
			System.out.println("Move disk 1: "+s+" to "+d);
			return;
		}
		
		tower(n-1,s,h,d);
		System.out.println("Move disk "+n+" from "+s+" to "+d);
		tower(n-1,h,d,s);

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		tower(n,'A','B','C');

	}

}
