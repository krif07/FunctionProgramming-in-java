package lambda.examples.consumer;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args){
		
		Consumer<String> c1 = (s) -> {System.out.println(s.toUpperCase());};
		c1.accept("krif");
		Consumer<String> c2 = s -> System.out.println(s.toLowerCase());
		c2.accept("krif");
		
		c1.andThen(c2).accept("hola muNdo");
	}
}
