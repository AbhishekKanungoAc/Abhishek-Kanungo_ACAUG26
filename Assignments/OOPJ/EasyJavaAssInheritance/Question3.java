public class Question3 {

    public static void main(String[] args) {
		/*
		    	3. Create a class named 'Rectangle' with two data members 'length' and 'breadth' and
two methods to print the area and perimeter of the rectangle respectively. Its
constructor having parameters for length and breadth is used to initialize length and
breadth of the rectangle. Let class 'Square' inherit the 'Rectangle' class with its
constructor having a parameter for its side. Print the area and perimeter of a rectangle
and a square.
		    	*/
        Rectangle r = new Rectangle(10, 5);

        System.out.println("Rectangle:");
        r.printArea();
        r.printPerimeter();

        Square s = new Square(5);

        System.out.println("\nSquare:");
        s.printArea();
        s.printPerimeter();
    }
}

class Rectangle {

    protected double length;
    protected double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void printArea() {
        double area = length * breadth;
        System.out.println("Area: " + area);
    }

    public void printPerimeter() {
        double perimeter = 2 * (length + breadth);
        System.out.println("Perimeter: " + perimeter);
    }
}

class Square extends Rectangle {

    Square(double side) {
        super(side, side);
    }
}
