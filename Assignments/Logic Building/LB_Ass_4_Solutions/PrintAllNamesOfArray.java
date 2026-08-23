import java.util.Scanner;

public class PrintAllNamesOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element you want:");
        int x = sc.nextInt();
        String[] arr = new String[x];
        System.out.print("Enter " + x + " Names:");
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextLine();
        }
        for (String i : arr) {
             System.out.println(i+" ");
        }
       
    }
}
