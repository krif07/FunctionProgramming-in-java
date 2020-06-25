package lambda.examples.streams;

import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		int sum = numbers.stream().mapToInt(i -> i).sum();
		System.out.println("Sum " + sum);
		
		Long count = numbers.stream().mapToInt(i -> i).count();
		System.out.println("Count " + count);
		
		// to multiply we need the 1 as the initial value
		System.out.println("Multi " + numbers.stream().reduce(1, (a, b) -> a * b));
		
		// To sum we need the 0 as the initial value
		System.out.println("Sum " + numbers.stream().reduce(0,  (a, b) -> a + b));
	}
}
