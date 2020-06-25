package lambda.examples.functioninterface;

import java.util.function.Function;

public class FunctionExample {

	static Function<String, String> f1 = name -> name.toUpperCase();
	static Function<String, String> f2 = name -> name.concat(" features");
	static Function<String, Integer> f3 = name -> name.length();
	
	public static void main(String[] args) {
		System.out.println("Result2: " + f1.apply("java"));
		System.out.println("Result2: " + f2.apply("java"));
		System.out.println("Result3: " + f1.andThen(f2).apply("java"));
		System.out.println("Result4: " + f2.andThen(f1).apply("java"));
		System.out.println("Result5: " + f1.compose(f2).apply("java"));
		
		System.out.println("Tam: " + f3.apply("krif07"));
	}
	
}
