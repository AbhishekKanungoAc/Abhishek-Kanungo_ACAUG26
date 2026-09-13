
public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		1. Create a class with a method that prints "This is parent class" and its subclass
			with another method that prints "This is child class". Now, create an object for
			each of the class and call
		1 - method of parent class by object of parent class
		2 - method of child class by object of child class
		3 - method of parent class by object of child class
		
		*/
		ParentClass p = new ParentClass();
		p.Diaplay();
		ChildClass c = new ChildClass();
		c.Show();
		c.Diaplay();
		

	}

}

class ParentClass{
	
	public void Diaplay() {
		System.out.println("This is Parent Class");
	}
}

class ChildClass extends ParentClass{
	
	public void Show() {
		System.out.println("This is Child Class");
	}
}
