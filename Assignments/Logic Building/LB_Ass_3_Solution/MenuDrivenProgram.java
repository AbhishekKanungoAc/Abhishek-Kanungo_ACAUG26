import java.util.Scanner;

public class MenuDrivenProgram {
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    char c;
    boolean bool;
    String str;

    public static void main(String[] args) {
        int choice;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("==========Menu============");
            System.out.println("1: Grade Evalution System");
            System.out.println("2: Leap Year Check");
            System.out.println("3: Day of the week");
            System.out.println("4: Identify Default Values of Variables");
            System.out.println("5: Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the marks of Maths, Science and History:");
                    int Maths = sc.nextInt();
                    int Science = sc.nextInt();
                    int History = sc.nextInt();
                    int AvgMarks = (Maths + Science + History) / 3;
                    System.out.println("Average Marks is:"+AvgMarks);
                    if (AvgMarks >= 90) {
                        System.out.println("Grade A");
                    } else if (89 <= AvgMarks && AvgMarks >= 70) {
                        System.out.println("Grade B");
                    } else if (69 <= AvgMarks && AvgMarks >= 50) {
                        System.out.println("Grade C");
                    } else if (49 <= AvgMarks && AvgMarks >= 30) {
                        System.out.println("Grade D");
                    } else {
                        System.out.println("Fail");
                    }
                    break;

                case 2:
                    System.out.println("Enter the year to chcek:");
                    int y = sc.nextInt();
                    if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
                        System.out.println(y + " is leap year");
                    } else {
                        System.out.println(y + " not a leap year");
                    }
                    break;

                case 3:
                    System.out.println("Enter the Day to check:");
                    int Day = sc.nextInt();
                    switch (Day) {
                        case 1:
                            System.out.println("Day is Monday");
                            break;
                        case 2:
                            System.out.println("Day is Tuesday");
                            break;
                        case 3:
                            System.out.println("Day is Wednesday");
                            break;
                        case 4:
                            System.out.println("Day is Thursday");
                            break;
                        case 5:
                            System.out.println("Day is Friday");
                            break;
                        case 6:
                            System.out.println("Day is Saturday");
                            break;
                        case 7:
                            System.out.println("Day is Sunday");
                            break;
                        default:
                            System.out.println("Invalid Number");
                    }
                    break;

                case 4:
                    System.out.println("Default values of variables:");
                    MenuDrivenProgram obj = new MenuDrivenProgram();
                    System.out.println("byte: " + obj.b);
                    System.out.println("short: " + obj.s);
                    System.out.println("int: " + obj.i);
                    System.out.println("long: " + obj.l);
                    System.out.println("float: " + obj.f);
                    System.out.println("double: " + obj.d);
                    System.out.println("char: " + (int) obj.c);
                    System.out.println("boolean: " + obj.bool);
                    System.out.println("String:"+obj.str);

                    break;

                case 5:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice, Please try again");
                    break;
            }
        } while (choice != 5);

    }
}
