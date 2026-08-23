import java.util.*;
public class PrintNumberUsingForLoop{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int num = sc.nextInt();
        for (int i = 0; i <= num ; i++) {
            System.out.print(i+ " ");
        }
    }
}