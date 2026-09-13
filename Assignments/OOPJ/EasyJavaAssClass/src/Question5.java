
public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		5. Write a program that would print the information (name, year of joining, salary,
		address) of three employees by creating a class named 'Employee'. The output
		should be as follows:
		Name        Year of joining        Address
		Robert            1994                64C- WallsStreat
		Sam                2000                68D- WallsStreat
		John                1999                26B- WallsStreat
		*/	
		System.out.println("Name		Year of joining		Salary		Address");
		Employee obj = new Employee("Robert", 1194, 12500,"64- WallsStreat");
		obj.Display();
		Employee obj1 = new Employee("Sam", 2000, 13000,"65- WallsStreat");
		obj1.Display();
		Employee obj2 = new Employee("John", 1999, 12000,"66- WallsStreat");
		obj2.Display();
	
	
	}

}

class Employee{
	
	String name;
	int yearOfJoining;
	float salary;
	String address;
	public Employee(String name, int yearOfJoining, float salary, String address) {
		super();
		this.name = name;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
		this.address = address;
	}
	
	public void Display() {
		
		System.out.println(name+"		"+yearOfJoining+"			"+salary+"     	"+address);
		
		
	}
	
	 	
	
	
	
}