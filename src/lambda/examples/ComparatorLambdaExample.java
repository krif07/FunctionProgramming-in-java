package lambda.examples;

import java.util.Comparator;

public class ComparatorLambdaExample {
	
	public static void main(String[] args) {
		
		//Before
		Comparator<Integer> c1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				return x.compareTo(y);
			}
			
		};		
		System.out.println("Comparator 1: " + c1.compare(15, 10));
		
		//After
		Comparator<Integer> c2 = (Integer x, Integer y) -> x.compareTo(y);
		System.out.println("Compartor 2: " + c2.compare(15, 15));
		
		Comparator<Integer> c3 = (x, y) -> x.compareTo(y);
		System.out.println("Comparator 3: " + c3.compare(10, 15));
	}

}
