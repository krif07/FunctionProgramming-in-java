package lambda.examples.streams.maps;

import java.util.function.Predicate;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class StreamMapFilterReduceExample {

	static Predicate<Person> p1 = person -> person.getHeight() > 140;
	static Predicate<Person> p2 = person -> person.getGender().equals("Male");
	
	public static void main(String[] args) {
		//Count kids
		int sum = PersonRepository.getAllPersons()
		.stream()
		.filter(p1.and(p2))
		.map(Person::getKids)
		//.reduce(0, (a, b) -> a + b)
		.reduce(0, Integer::sum);
		
		System.out.println("Total kids " + sum);
	}
}
