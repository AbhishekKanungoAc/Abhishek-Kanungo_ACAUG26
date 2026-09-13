
public class Question6 {

	public static void main(String[] args) {
				/*
		 * 6. Write a program by creating an 'Employee' class having the following methods
			and print the final salary.
				1 - 'getInfo()' which takes the salary, number of hours of work per day of employee
					as parameter
				2 - 'addSal()' which adds $10 to salary of the employee if it is less than $500.
				3 - 'addWork()' which adds $5 to salary of employee if the number of hours of
					work per day is more than 6 hours.
		 */
		Employeee objjj = new Employeee();
		objjj.getInfo(456.5f, 6.2f);
		objjj.addSal();
		objjj.addWork();
		System.out.println("The Final Salary is: " + objjj.salary);
	
		
	}

}

class Employeee{
	
	float salary;
	float WorkingHours;
	
	
	public void getInfo(float salary, float WorkingHours) {
		this.salary = salary;
		this.WorkingHours = WorkingHours;
		
			}
	
	public void addSal() {
		if (salary<500)
			salary += 10;
	}
	
	public void addWork() {
		if (WorkingHours>6)
			salary += 5;
	}
	
	
	
	
}