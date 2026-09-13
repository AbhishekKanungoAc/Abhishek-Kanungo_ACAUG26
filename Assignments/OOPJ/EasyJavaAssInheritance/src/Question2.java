
public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		2. Create a class named 'Member' having the following members:
Data members
1 - Name
2 - Age
3 - Phone number
4 - Address
5 - Salary
It also has a method named 'printSalary' which prints the salary of the members.
Create an object of the above class and take input from the console for each of the
fields and finally display the data.
Now create a class inherited from Members called PrimeMembers and add the
properties
1. JoiningYear
2. JoiningFeesMember
3. isActive
To the PrimeMembers add a method called display and display all the fields from
the parent class and derived class. Each of the above classes should have their
respective accessors and mutators.
		*/		
		PrimeMember m = new PrimeMember();
		System.out.println("Enter the name of member:");
		m.setName(ConsoleInput.getString());
		System.out.println("Enter the Age of member:");
		m.setAge(ConsoleInput.getInt());
		System.out.println("Enter the Number of member:");
		m.setNumber(ConsoleInput.getString());
		System.out.println("Enter the Address of member:");
		m.setAddress(ConsoleInput.getString());
		System.out.println("Enter the salary of member:");
		m.setSalary(ConsoleInput.getString());
		System.out.println("Enter the Joining Year:"); 
		m.setJoiningYear(ConsoleInput.getInt()); 
		System.out.println("Enter the Joining Fees:"); 
		m.setJoiningFees(ConsoleInput.getFloat());
		
		System.out.println("Is the member active? true/false:"); 
		m.setActive(true);  
		m.printSalary(); 
		m.display();
		
	}

}
class Member{
	
	private String Name;
	private int Age;
	private String Number;
	private String Address;
	private String Salary;
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}
	
	public void printSalary() {
		System.out.println("Salary: " + Salary);
	}
}

class PrimeMember extends Member{
	private int JoiningYear;
	private float JoiningFees; 
	private boolean isActive;
	
	public int getJoiningYear() {
		return JoiningYear;
	}

	public void setJoiningYear(int joiningYear) {
		JoiningYear = joiningYear;
	}

	public float getJoiningFees() {
		return JoiningFees;
	}

	public void setJoiningFees(float joiningFees) {
		JoiningFees = joiningFees;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void Show() {
		System.out.println("This is Child Class");
	}
	public void display() {
		System.out.println("\n----- Member Details -----"); 
		System.out.println("Name: " + getName()); 
		System.out.println("Age: " + getAge()); 
		System.out.println("Phone Number: " + getNumber()); 
		System.out.println("Address: " + getAddress()); 
		System.out.println("Salary: " + getSalary()); 
		System.out.println("\n----- Prime Member Details -----"); 
		System.out.println("Joining Year: " + getJoiningYear()); 
		System.out.println("Joining Fees: " + getJoiningFees()); 
		System.out.println("Active: " + isActive()); 
		}
}
