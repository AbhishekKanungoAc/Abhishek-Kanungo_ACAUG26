import java.util.Scanner;

public class MultiplicationTable {
    
    public static void printTable(int t){
        for(int i=1; i<=10; i++){
            int num = t*i;
            System.out.println(num);
        }
    }
    
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the number for multiplication table: ");
     int n = sc.nextInt();  
     System.out.println("table of "+ n +" is");
     printTable(n);  
    }
}
