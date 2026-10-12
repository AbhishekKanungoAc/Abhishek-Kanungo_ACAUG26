package assignment2;

/*
Example
Input: attendance = [1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0] (15 days)
Output: Days present : 11 of 15
 Attendance : 73.33 %
 Eligible : NO
 Longest presence : 5 days (day 10 to day 14)
 Longest absence : 2 days (day 8 to day 9)
 Days needed for 75%: 1 (12 of 16 = 75.00 %)



*/
public class ExamEligFromAttendance {

	static int countPresent(int[] att) {
		// TODO: count how many 1s are in the array
		int count = 0;
		for (int i = 0; i < att.length; i++) {
			if (att[i] == 1) {
				count++;
			}
		}
		return count;
	}

	static double percentage(int present, int total) {
		// TODO: careful - present / total with int values gives 0!
		double per = ((double) present / total) * 100;

		return per;
	}

	static void longestStreak(int[] att, int value) {

	    int count = 0;
	    int max = 0;
	    int start = 0;
	    int end = 0;

	    for (int i = 0; i < att.length; i++) {

	        if (att[i] == value) {

	            count++;

	            if (count > max) {
	                max = count;
	                end = i;
	                start = i - count + 1;
	            }

	        } else {
	            count = 0;
	        }
	    }

	    if (value == 1)
	        System.out.println("Longest presence : " + max +
	                " days (day " + (start + 1) + " to day " + (end + 1) + ")");

	    else
	        System.out.println("Longest absence : " + max +
	                " days (day " + (start + 1) + " to day " + (end + 1) + ")");
	}

	static int daysNeeded(int present, int total) {
		// TODO: keep adding one present day until percentage >= 75
		
		int days = 0;
		 while (((double) present / total) * 100 < 75) {
			 present++;
			 days++;
			 total++;
		}
		return days;
	}

	public static void main(String[] args) {
		int[] att = { 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0 };
		// TODO: call the methods above and print the report
		// ExamEligFromAttendance rr =new ExamEligFromAttendance();
		// countPresent(att);
		System.out.println("Days present : " + countPresent(att) + " of " + att.length);
		double el = percentage(countPresent(att), att.length);
		System.out.printf("Attendance : %.2f %%", el);
		System.out.println();

		if (el > 75) {
			System.out.println("Eligible : YES");
		} else {
			System.out.println("Eligible : NO");

		}
		
		longestStreak(att,1);
		longestStreak(att,0);
		
		int days = daysNeeded(countPresent(att),att.length);
		int newPresent = countPresent(att) + days;
        int newTotal = att.length + days;

        double newPercentage =
            percentage(newPresent, newTotal);

        System.out.printf(
            "Days needed for 75%%: %d (%d of %d = %.2f %%)",
            days,
            newPresent,
            newTotal,
            newPercentage
        );
		
		
		

	}

}
