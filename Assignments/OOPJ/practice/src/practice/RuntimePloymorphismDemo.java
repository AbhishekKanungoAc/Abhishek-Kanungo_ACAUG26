package practice;

class Vehicle{
	
	void start() {
		System.out.println("Vehicle start");
	}
}

class Car extends Vehicle{
	void start() {
		System.out.println("Car start with key");
	}
}
class Bike extends Vehicle{
	void start() {
		System.out.println("Bike satrt with self-start");
	}
}

public class RuntimePloymorphismDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 4) Create a Vehicle class with start() method. Create Car and Bike classes
		 * that override start(). Demonstrate runtime polymorphism using a parent class
		 * reference.
		 */

		Vehicle v;
		v = new Car();
		v.start();
		
		v = new Bike();
		
		v.start();
		
	}

}
