package InterfacePracties;


		// TODO Auto-generated method stub
		/*
		 * 1. Start by making a normal Java-7-style application with these features: •
		 * An interface called RegularPolygon with two abstract methods: getNumSides and
		 * getSideLength • A class EquilateralTriangle that implements the interface,
		 * has getNumSides return 3 and getSideLength return an instance variable that
		 * is set by the constructor. • A class Square that implements the interface,
		 * has getNumSides return 4 and getSideLength return an instance variable that
		 * is set by the constructor.
		 * 
		 * 2. Add a static totalSides method, that given a RegularPolygon[], returns the
		 * sum of the number of sides of all the elements.
		 * 
		 * 3. Add two default methods: • getPerimeter (n * length, where n is the number
		 * of sides) • getInteriorAngle ( (n-2)π/n in radians)
		 * 
		 * 
		 * 
		 */

interface RegularPolygon {

    // Abstract method: every polygon must tell its number of sides
    int getNumSides();

    // Abstract method: every polygon must tell its side length
    double getSideLength();


    // Default method: calculates perimeter
    default double getPerimeter() {
        return getNumSides() * getSideLength();
    }


    // Default method: calculates interior angle in radians
    default double getInteriorAngle() {
        int n = getNumSides();

        return (n - 2) * Math.PI / n;
    }


    // Static method: calculates total number of sides
    // of all polygons in the array
    static int totalSides(RegularPolygon[] polygons) {

        int total = 0;

        for (RegularPolygon polygon : polygons) {
            total = total + polygon.getNumSides();
        }

        return total;
    }
}


// --------------------------------------------------
// EquilateralTriangle
// --------------------------------------------------

class EquilateralTriangle implements RegularPolygon {

    private double sideLength;

    // Constructor
    public EquilateralTriangle(double sideLength) {
        this.sideLength = sideLength;
    }

    // Triangle has 3 sides
    @Override
    public int getNumSides() {
        return 3;
    }

    // Returns the side length
    @Override
    public double getSideLength() {
        return sideLength;
    }
}


// --------------------------------------------------
// Square
// --------------------------------------------------

class Square implements RegularPolygon {

    private double sideLength;

    // Constructor
    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    // Square has 4 sides
    @Override
    public int getNumSides() {
        return 4;
    }

    // Returns the side length
    @Override
    public double getSideLength() {
        return sideLength;
    }
}


// --------------------------------------------------
// Main class
// --------------------------------------------------

public class Question1 {

    public static void main(String[] args) {

        // Create Triangle with side length 5
        EquilateralTriangle triangle =
                new EquilateralTriangle(5);

        // Create Square with side length 10
        Square square =
                new Square(10);


        // Display Triangle information
        System.out.println("Triangle");
        System.out.println("Sides: " + triangle.getNumSides());
        System.out.println("Side Length: " + triangle.getSideLength());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Interior Angle: "
                + triangle.getInteriorAngle());


        System.out.println();


        // Display Square information
        System.out.println("Square");
        System.out.println("Sides: " + square.getNumSides());
        System.out.println("Side Length: " + square.getSideLength());
        System.out.println("Perimeter: " + square.getPerimeter());
        System.out.println("Interior Angle: "
                + square.getInteriorAngle());


        System.out.println();


        // Create an array containing different polygons
        RegularPolygon[] polygons = {
                triangle,
                square
        };


        // Call static method using interface name
        int total = RegularPolygon.totalSides(polygons);

        System.out.println("Total Sides: " + total);
    }
}

