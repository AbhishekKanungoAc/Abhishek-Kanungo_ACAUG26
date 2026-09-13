
public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*2. Write a program to print the area and perimeter of a triangle having
		 * sides of 3, 4 and 5 units by creating a class named 'Triangle' with
		 * constructor having the three sides as its parameters.
		 */
		Triangle obj = new Triangle(3,4,5);
		obj.Diaplay();
	
	}

}
 class Triangle{
	 int L,B,H;
	 
	 Triangle(int n,int n2, int n3){
		 L=n;
		 B=n2;
		 H=n3;
	 }
	 
	 public float CalculateArea() {
		 
		 return (B*H)/2;
	 }
	 
	 public int CalculateParameter() {
		 
		 return L+B+H;
	 }
	 
	 public void Diaplay() {
		 
		 System.out.println("Area Of Triangle: "+CalculateArea());
		 System.out.println("Area Of Triangle: "+CalculateParameter());
	 }
	 
	 
 }