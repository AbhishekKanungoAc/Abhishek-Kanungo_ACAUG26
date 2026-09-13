class Complex {

    // A complex number has two parts
    double real;
    double imaginary;

    // Method for addition
    void sum(Complex c) {

        // Add real parts
        double r = real + c.real;

        // Add imaginary parts
        double i = imaginary + c.imaginary;

        System.out.println("Sum = " + r + " + " + i + "i");
    }

    // Method for subtraction
    void difference(Complex c) {

        // Subtract real parts
        double r = real - c.real;

        // Subtract imaginary parts
        double i = imaginary - c.imaginary;

        System.out.println("Difference = " + r + " + " + i + "i");
    }

    // Method for multiplication
    void product(Complex c) {

        // Formula:
        // Real part = (a*c) - (b*d)
        double r = (real * c.real) -
                   (imaginary * c.imaginary);

        // Formula:
        // Imaginary part = (a*d) + (b*c)
        double i = (real * c.imaginary) +
                   (imaginary * c.real);

        System.out.println("Product = " + r + " + " + i + "i");
    }
}



public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    // Creating two Complex objects
	        Complex c1 = new Complex();
	        Complex c2 = new Complex();

	        // Taking first complex number
	        System.out.print("Enter real part of first number: ");
	        c1.real = ConsoleInput.getFloat();

	        System.out.print("Enter imaginary part of first number: ");
	        c1.imaginary = ConsoleInput.getFloat();
	        // Taking second complex number
	        System.out.print("Enter real part of second number: ");
	        c2.real = ConsoleInput.getFloat();

	        System.out.print("Enter imaginary part of second number: ");
	        c2.imaginary = ConsoleInput.getFloat();

	        // Perform operations
	        c1.sum(c2);
	        c1.difference(c2);
	        c1.product(c2);

	       
	    }

	}

