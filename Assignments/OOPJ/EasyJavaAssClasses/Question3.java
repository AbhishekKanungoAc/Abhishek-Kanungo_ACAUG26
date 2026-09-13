
public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *3. Write a program to print the area of two rectangles having sides (4,5)
		 * and (5,8) respectively by creating a class named 'Rectangle' with a method
		 * named 'area' which returns the area and length and breadth passed as
		 * parameters to its constructor
		 */
		Rectangle obj = new Rectangle(4,5);
		Rectangle obj1 = new Rectangle(5,8);
		obj.Diaplay();
		obj1.Diaplay();
		

	}

}

class Rectangle{
	 int L,B;
	 
	 Rectangle(int n,int n2){
		 L=n;
		 B=n2;
		 
	 }
	 
	 public float CalculateArea() {
		 
		 return L*B;
	 }
	 
	 public int CalculateParameter() {
		 
		 return L+B;
	 }
	 
	 public void Diaplay() {
		 
		 System.out.println("Area Of Rectangle: "+CalculateArea());
		 System.out.println("Area Of Rectangle: "+CalculateParameter());
	 }
	 
	 
}