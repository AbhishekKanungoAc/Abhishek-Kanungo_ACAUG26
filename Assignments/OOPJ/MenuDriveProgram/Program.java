public class Program {

    public static void main(String[] args) {

        Date objDate = new Date();

        int choice;

        do {

            System.out.println("--------------------------------");
            System.out.println("          Date Menu");
            System.out.println("--------------------------------");

            System.out.println("1. Set Date");
            System.out.println("2. Add Days");
            System.out.println("3. Add Months");
            System.out.println("4. Add Years");
            System.out.println("5. Display");
            System.out.println("6. Compare Dates");
            System.out.println("7. Exit");

            System.out.println("--------------------------------");

            System.out.print("Enter your choice: ");

            choice = ConsoleInput.getInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter the day: ");
                    int day = ConsoleInput.getInt();

                    System.out.print("Enter the month: ");
                    int month = ConsoleInput.getInt();

                    System.out.print("Enter the year: ");
                    int year = ConsoleInput.getInt();

                    objDate.setDate(day, month, year);

                    System.out.println("Date set successfully.");

                    break;


                case 2:

                    System.out.print("Enter number of days: ");

                    int days = ConsoleInput.getInt();

                    objDate.addDays(days);

                    System.out.println("Days added successfully.");

                    break;


                case 3:

                    System.out.print("Enter number of months: ");

                    int months = ConsoleInput.getInt();

                    objDate.addMonths(months);

                    System.out.println("Months added successfully.");

                    break;


                case 4:

                    System.out.print("Enter number of years: ");

                    int years = ConsoleInput.getInt();

                    objDate.addYears(years);

                    System.out.println("Years added successfully.");

                    break;


                case 5:

                    System.out.println(
                        objDate.getDay() + "/" +
                        objDate.getMonth() + "/" +
                        objDate.getYear()
                    );

                    break;


                case 6:

                    Date compareDate = new Date();

                    System.out.println("Enter date to compare:");

                    System.out.print("Enter the day: ");
                    int cDay = ConsoleInput.getInt();

                    System.out.print("Enter the month: ");
                    int cMonth = ConsoleInput.getInt();

                    System.out.print("Enter the year: ");
                    int cYear = ConsoleInput.getInt();

                    compareDate.setDate(cDay, cMonth, cYear);

                    int result = objDate.compare(compareDate);

                    if (result == 0) {

                        System.out.println("Both dates are equal.");
                    }

                    else if (result < 0) {

                        System.out.println(
                            "Current date is before given date."
                        );
                    }

                    else {

                        System.out.println(
                            "Current date is after given date."
                        );
                    }

                    break;


                case 7:

                    System.out.println("Program exited.");

                    break;


                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);
    }
}

