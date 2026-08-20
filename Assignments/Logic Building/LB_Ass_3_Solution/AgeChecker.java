import java.util.*;
 public class AgeChecker {

    static void checkAgeCategory(int n){
        if (n <= 18 ) {
            System.out.println("Minor");
        }else if (n>18 && n<=50) {
            System.out.println("Adult");
        }else
        {
            System.out.println("Senior citizen");
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the age:");
        int age = sc.nextInt();
        checkAgeCategory(age);
    }
 }