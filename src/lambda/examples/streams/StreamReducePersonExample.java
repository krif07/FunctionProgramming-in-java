package lambda.examples.streams;

import java.util.List;
import java.util.Optional;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class StreamReducePersonExample {
	
	public static void main(String[] asrgs) {
		printNames();
		System.out.println("Tallest person : " + getTallestPerson().get());
	}
	
	private static void printNames() {
		String concatNames = PersonRepository.getAllPersons()
				.stream()
				.map(Person::getName)
				.reduce("", (a, b) -> a.concat(b).concat(" "));
		
		System.out.println(concatNames);
	}
	
	private static Optional<Person> getTallestPerson() {
		
		List<Person> list = PersonRepository.getAllPersons();
		
		return list.stream()
				.reduce(
					(person1, person2) -> person1.getHeight() >= person2.getHeight() ? person1 : person2
				);
	}

}
