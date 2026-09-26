package practice;

import java.util.Arrays;
import java.util.List;

public class LambdaForEvenNo {
	// Lambda expression use karke sirf even numbers print karo.
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);
		
		 numbers.stream()
		 		.filter(x->x%2==0)
		 		.forEach(x->System.out.println(x));

	}
}
