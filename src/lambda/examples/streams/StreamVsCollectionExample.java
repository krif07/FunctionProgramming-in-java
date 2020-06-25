package lambda.examples.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class StreamVsCollectionExample {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("A");
		names.add("B");
		names.add("C");
		
		for(String name : names) {
			System.out.println(name);
		}
		
		Stream<String> stream = names.stream();
		stream.forEach(name -> System.out.println(name));
		
		// No se puede volver a recorrer el stream
		// stream.forEach(name -> System.out.println(name));

		System.out.println("----------------------------------------------------");
		List<String> peopleNames = PersonRepository
				.getAllPersons()
				.stream()
				.peek(per -> System.out.println(per)) // Para hacer debug
				.map(Person::getName)
				.peek(System.out::println)			  // Para hacer debug	
				.collect(Collectors.toList());
	}
}
