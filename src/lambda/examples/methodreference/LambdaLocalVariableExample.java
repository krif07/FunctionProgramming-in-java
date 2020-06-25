package lambda.examples.methodreference;

import java.util.function.Consumer;

public class LambdaLocalVariableExample {

	static int classInteger = 0;
	
	public static void main(String[] args) {
		int i = 10;
		
		Consumer<Integer> c1 = myInt -> {
			// Esto no se puede hacer
			// i++;
			
			System.out.println("Result " + i);
			System.out.println("Result sum " + (i + myInt));
			myInt++;
			System.out.println("Result " + myInt);
			
			// Esto si se permite
			classInteger++;
			System.out.println("Result " + classInteger);
		};
		
		c1.accept(13);
	}
}
