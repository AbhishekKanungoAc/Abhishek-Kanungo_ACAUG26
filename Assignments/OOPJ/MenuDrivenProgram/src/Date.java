public class Date {

    private int day;
    private int month;
    private int year;

    // Setter / Mutator
    public void setDate(int dd, int mm, int yy) {

        year = yy;

        // Check month
        if (mm < 1 || mm > 12) {
            month = 1;
        } else {
            month = mm;
        }

        // Check day according to month
        if (month == 1 || month == 3 || month == 5 ||
            month == 7 || month == 8 || month == 10 ||
            month == 12) {

            if (dd < 1 || dd > 31)
                day = 1;
            else
                day = dd;
        }

        else if (month == 4 || month == 6 ||
                 month == 9 || month == 11) {

            if (dd < 1 || dd > 30)
                day = 1;
            else
                day = dd;
        }

        else {

            // February
            if (isLeapYear()) {

                if (dd < 1 || dd > 29)
                    day = 1;
                else
                    day = dd;

            } else {

                if (dd < 1 || dd > 28)
                    day = 1;
                else
                    day = dd;
            }
        }
    }                        

    // Check Leap Year
    private boolean isLeapYear() {

        if (year % 400 == 0)
            return true;

        if (year % 100 == 0)
            return false;

        if (year % 4 == 0)
            return true;

        return false;
    }

    // Get number of days in current month
    private int getDaysInMonth() {

        if (month == 1 || month == 3 || month == 5 ||
            month == 7 || month == 8 || month == 10 ||
            month == 12) {

            return 31;
        }

        else if (month == 4 || month == 6 ||
                 month == 9 || month == 11) {

            return 30;
        }

        else {

            // February
            if (isLeapYear())
                return 29;
            else
                return 28;
        }
    }

    // Add Days
    public void addDays(int days) {

        for (int i = 0; i < days; i++) {

            day++;

            if (day > getDaysInMonth()) {

                day = 1;
                month++;

                if (month > 12) {

                    month = 1;
                    year++;
                }
            }
        }
    }

    // Add Months
    public void addMonths(int months) {

        for (int i = 0; i < months; i++) {

            month++;

            if (month > 12) {

                month = 1;
                year++;
            }

            // Adjust day
            if (day > getDaysInMonth()) {

                day = getDaysInMonth();
            }
        }
    }

    // Add Years
    public void addYears(int years) {

        year = year + years;

        // Handle 29 February
        if (month == 2 && day == 29) {

            if (!isLeapYear()) {

                day = 28;
            }
        }
    }

    // Compare Date
    public int compare(Date obj) {

        if (year < obj.year)
            return -1;

        if (year > obj.year)
            return 1;

        if (month < obj.month)
            return -1;

        if (month > obj.month)
            return 1;

        if (day < obj.day)
            return -1;

        if (day > obj.day)
            return 1;

        return 0;
    }

    // Getters / Accessors

    public int getDay() {

        return day;
    }

    public int getMonth() {

        return month;
    }

    public int getYear() {

        return year;
    }
}
