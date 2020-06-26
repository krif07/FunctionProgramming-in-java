package lambda.examples.streams;

import java.util.Arrays;
import java.util.List;

public class StreamLimitExample {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Orange", "Graphs", "Bannana", "Pineaple");
		fruits.stream().limit(2).forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		Integer result = numbers.stream()
		.limit(4)
		.reduce(0, (a, b) -> a + b);
		
		System.out.println("result " + result);
		
		Integer skipt = numbers.stream()
		.skip(5)
		.reduce(0, (a, b) -> a + b);
		
		System.out.println("skipt " + skipt);
	}
}
