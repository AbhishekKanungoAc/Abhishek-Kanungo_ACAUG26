import java.util.Scanner;

public class SumOfNumToN {
    public static void calculateSum(int t){
        int s=0;
        for(int i=1; i<=t; i++){
            s = s+i;
            
        }
        System.out.println("The sum of num from 1 to "+t+ " is:"+s);
    }
    
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the number: ");
     int n = sc.nextInt();  
     calculateSum(n);  
    }
}
