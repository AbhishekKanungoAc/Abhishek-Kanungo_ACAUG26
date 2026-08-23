import java.util.Scanner;

public class CountPosAndNegNumInArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element you want:");
        int x = sc.nextInt();
        int count = 0;
        int count1 = 0;
        int[] arr = new int[x];
        System.out.println("Enter " + x + " numbers:");
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i <x; i++) {
            if (arr[i]>0 ) {
                count ++;
                
            }else if (arr[i]<0) {
                count1 ++;
                
            }
        }
        System.out.println("Positive number:"+count);
        System.out.println("Negative number:"+count1);
    }
}
