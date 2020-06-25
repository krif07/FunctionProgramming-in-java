package lambda.examples.methodreference;

import java.util.Comparator;

public class MethodReferenceExample {

	/* Sintax */
	// ClassName :: method
	
	public static void main(String[] args) {
		// Clasic way
		System.out.println("Compare result " + MethodReferenceExample.compare(10,  15));
		
		// With Functional programming
		Comparator<Integer> comparator = MethodReferenceExample::compare;
		System.out.println("Compare result " + comparator.compare(15,  10));
		
	}
	
	public static Integer compare(Integer n1, Integer n2) {
		return n1.compareTo(n2);
	}
}
