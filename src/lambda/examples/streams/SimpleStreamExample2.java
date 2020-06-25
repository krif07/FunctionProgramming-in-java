package lambda.examples.streams;

import java.util.List;
import java.util.stream.Collectors;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class SimpleStreamExample2 {

	public static void main(String[] args) {
		
		List<String> personHobbies = 
				PersonRepository
				.getAllPersons()					// List of people
				.stream()							// Stream of people
				.map(Person::getHobbies)			// Stream<List<String>>
				.flatMap(List::stream)				// Stream<String>
				.distinct()
				.collect(Collectors.toList());		// collection to be returned
		
		System.out.println(personHobbies);
	}	
	
}
