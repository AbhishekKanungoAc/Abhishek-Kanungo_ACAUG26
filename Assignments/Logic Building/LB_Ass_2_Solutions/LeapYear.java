public class LeapYear {
    public static void main(String[] args) {
        int y = 1900;
        if ((y%4 == 0 && y%100 != 0) || y%400 == 0) {
            System.out.println(y+" is leap year");
        }else{ System.out.println(y+" not a leap year");
        }
    }
}
