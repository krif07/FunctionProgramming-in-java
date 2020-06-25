package lambda.examples.functioninterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryExample {

	
	static UnaryOperator<String> uo1 = name -> name.toUpperCase();
	static UnaryOperator<Integer> uoSquare = num -> num * num;
	static Comparator<Integer> comp = (a, b) -> a.compareTo(b);
	
	static BinaryOperator<Integer> bo1 = BinaryOperator.maxBy(
			(a, b) -> (a > b) ? 1 : (a == b) ? 0 : -1
	);
	static BinaryOperator<Integer> bo2 = BinaryOperator.maxBy(comp);
	static BinaryOperator<Integer> bo3 = BinaryOperator.minBy(comp);
	
	public static void main(String[] args) {
		
		Integer num = 7;		
		System.out.println(uo1.apply("krif07"));
		
		System.out.println("square of " + num + " is " + uoSquare.apply(num));		
		
		System.out.println("Binary Operator result 1: " + bo1.apply(10, 15));
		System.out.println("Binary Operator result 2: " + bo2.apply(10, 15));
		System.out.println("Binary Operator result 3: " + bo3.apply(10, 15));		
	}
}
