import java.util.Scanner;

public class SumOfAllEleOfArray {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of element you want:");
        int x = sc.nextInt();
        int sum =0;
        int[] arr = new int[x];
        System.out.println("Enter "+x+" integers:");
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : arr) {
            sum += i;
        }
        System.out.println("The sum of all numberss is:"+sum);
    }
}
