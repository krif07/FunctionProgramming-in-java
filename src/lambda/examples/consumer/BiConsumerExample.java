package lambda.examples.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
	
	public static void main(String[] args) {
		BiConsumer<Integer, Integer> c1 = (a,b) -> System.out.println("Add : " + (a+b));
		c1.accept(4, 7);
		
		List<Integer> list1 = Arrays.asList(Integer.parseInt("3"), Integer.parseInt("4"), Integer.parseInt("5"));
		List<Integer> list2 = Arrays.asList(Integer.parseInt("3"), Integer.parseInt("4"));
		
		BiConsumer<List<Integer>, List<Integer>> c2 = (l1,l2) -> {
			if(l1.size() == l2.size()) System.out.println("True");
			else System.out.println("False");
		};
		
		c2.accept(list1, list2);
	}
}
