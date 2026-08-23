import java.util.Arrays;
import java.util.Scanner;

public class FindLargestEleInArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element you want:");
        int x = sc.nextInt();
        int[] arr = new int[x];
        System.out.println("Enter " + x + " integers:");
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextInt();
        }
       
        Arrays.sort(arr);
        System.out.println("The Largest Element is: "+arr[x-1]);
    }
}
