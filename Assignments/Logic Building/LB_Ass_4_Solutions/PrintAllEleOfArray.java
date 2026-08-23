import java.util.*;

public class PrintAllEleOfArray {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of element you want:");
        int x = sc.nextInt();
        int[] arr = new int[x];
        System.out.println("Enter "+x+" integers:");
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
