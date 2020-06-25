package lambda.examples.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class SimpleStreamExample {

	public static void main(String[] args) {
		
		Stream<Integer> s1 = Stream.of(1,2,3,4,5,6);
		s1.forEach(p -> System.out.println(p));
		
		/* Collectors ayuda a transformar a otro tipo de stream */
		Map<String, List<String>> personMap = 
				PersonRepository
				.getAllPersons()
				.stream()
				.collect(
					Collectors.toMap(Person::getName, Person::getHobbies)
				);
		
		System.out.println(personMap);
		
		
		/***********************************************************/
		Predicate<Person> p1 = person -> person.getHeight() >= 140;
		
		personMap = PersonRepository.getAllPersons()
				.stream()
				.filter(p1)
				.collect(
					Collectors.toMap(Person::getName, Person::getHobbies)
				);
		System.out.println(personMap);
				
	}
}
