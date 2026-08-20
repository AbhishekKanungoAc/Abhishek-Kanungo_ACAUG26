import java.util.*;
class SumOfTwoNum{
    static void Sum(int n1, int n2){
        int ans = n1+n2;
        System.out.println("Sum of two number is: "+ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter the num2: ");
        int num2 = sc.nextInt();
        Sum(num1,num2);
}
}