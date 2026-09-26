package functionalInterfaceQ;

interface GenrateRandomNo{
	
	int genrate();
}
public class GenrateRandomNoLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4. Lambda expression to generate a 3 digit random number
		GenrateRandomNo gen = ()-> (int)(Math.random()*100)+1;
		System.out.println(gen.genrate());

	}

}
