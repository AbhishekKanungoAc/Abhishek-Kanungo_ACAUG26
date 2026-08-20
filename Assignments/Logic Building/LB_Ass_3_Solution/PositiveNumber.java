import java.util.*;
public class PositiveNumber {
        public static void askForPositiveNumber(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number: ");
            int n = sc.nextInt();
            do{
                System.out.println("Renter the number: ");
                n = sc.nextInt();
            }while(n<=0);
            System.out.println("You entered a positive number: "+n);
        }
        public static void main(String[] args) {
            
            askForPositiveNumber();
        }
}
