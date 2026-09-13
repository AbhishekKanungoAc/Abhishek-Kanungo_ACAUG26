
public class Question1 {


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			/*
			 * Create a class named 'Student' with String variable 'name' , integer variable
			 * 'roll_no'., String variable ‘phone_no’ and String variable ‘address’ a. 1.
			 * a. Assign the value of roll_no as '2' and that of name as "John" by creating an
			 * object of the class Student.
			 * b. Assign and print the roll number, phone number and address of two students
			 * having names "Sam" and "John" respectively by creating two objects of class
			 * 'Student
			 */
			
			Student obj = new Student();
			obj.name="john";
			obj.roll_no = 2;
			
			System.out.println("Part A");
			System.out.println("Name :"+obj.name);
			System.out.println("Name :"+obj.roll_no);
			
			
			System.out.println();
			System.out.println("Part B");
			
			Student Sam = new Student();
			Sam.name="Sam";
			Sam.roll_no = 01;
			Sam.phone_no ="256489356";
			Sam.address = "Dubai";
			
			Student John = new Student();
			John.name="John";
			John.roll_no = 02;
			John.phone_no ="256489356";
			John.address = "Dubai2";
			
			System.out.println("Name : "+Sam.name+ "\nRoll_Num: "+Sam.roll_no+"\nPhone_Num: "+Sam.phone_no+"\nAddress: "+Sam.address);
			System.out.println();
			System.out.println("Name : "+John.name+ "\nRoll_Num: "+John.roll_no+"\nPhone_Num: "+John.phone_no+"\nAddress: "+John.address);
			
		

		}

	}

	class Student{
		
		String name ;
		int roll_no ;
		String phone_no;
		String address ;
	}


