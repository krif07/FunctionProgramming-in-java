package lambda.examples.streams.maps;

import java.util.Comparator;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class StreamCustomSortExample {

	public static void main(String[] args) {
		
		Comparator<Integer> cHeight = (a, b) -> a.compareTo(b);
		Comparator<String> cName = (name1, name2) -> name1.compareTo(name2);
		
		System.out.println("Sort by Name");
		PersonRepository.getAllPersons()
			.stream()
			.sorted(Comparator.comparing(Person::getName))
			.forEach(System.out::println);
		
		System.out.println("Sort by Height");
		PersonRepository.getAllPersons()
			.stream()
			.sorted(Comparator.comparing(Person::getHeight))
			.forEach(p -> System.out.println(p));
		
		System.out.println("Sor by Name reversed");
		PersonRepository.getAllPersons()
			.stream()
			.sorted(Comparator.comparing(Person::getName).reversed())
			.forEach(System.out::println);
	}
}
