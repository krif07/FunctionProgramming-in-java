package lambda.examples.predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class PredicatePersonExample {

	static Predicate<Person> p1 = person -> person.getHeight() > 140;
	static Predicate<Person> p2 = person -> person.getGender().equals("Male");
	
	public static void main(String[] args) {		
		List<Person> personList = PersonRepository.getAllPersons();
		
		// This 
		/*personList.stream()
			.filter(p1).filter(p2)
			.collect(Collectors.toList())
			.forEach(person -> System.out.println(person)
		);*/
		
		// or this
		personList = personList.stream()
				.filter(p1).filter(p2)
				.collect(Collectors.toList());
		
		personList.forEach(person -> System.out.println(person));
		
		// or this
		/*personList.forEach(person ->{
			if(p1.and(p2).test(person)) {
				System.out.println(person);
			}
		});*/
	}
}
