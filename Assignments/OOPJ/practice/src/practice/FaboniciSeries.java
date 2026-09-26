package practice;

import java.util.Scanner;

public class FaboniciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number till u want fabonici series:");
		int num = sc.nextInt();
		int a=0;
		int b=1;
		
		for(int i=1;i<=num;i++) {
			System.out.print(a+" ");
			int c =a+b;
			a=b;
			b=c;
		}
		sc.close();

	}

}
