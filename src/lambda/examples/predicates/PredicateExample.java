package lambda.examples.predicates;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<Integer> p = num -> num >= 50;
		
		Integer i1 = Integer.parseInt("89");
		System.out.println(i1 + ">=" + 50 + " es " + p.test(i1));
		
		Predicate<Integer> lessThan = num -> num < 50;
		Predicate<Integer> gratherThan = num -> num > 50;
		Predicate<Integer> equalThan = num -> num == 50;
		
		
		Boolean result1 = lessThan.and(gratherThan).and(equalThan).test(100);
		Boolean result2 = lessThan.or(gratherThan).test(100);
		
		
		System.out.println("Result 1: " + result1);
		System.out.println("Result 2: " + result2);
	}
	
}
