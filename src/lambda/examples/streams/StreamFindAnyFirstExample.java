package lambda.examples.streams;

import java.util.function.Predicate;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class StreamFindAnyFirstExample {

	static Predicate<String> p1 = s -> s.length() > 7;
	static Predicate<Person> p2 = person -> person.getHeight() <= 140;
	static Predicate<Person> p3 = person -> person.getGender().equals("Female");
	
	public static void main(String[] args) {
		
		System.out.println("Any who is <= 140 " + findAny());
		System.out.println("First Female " + findFirst());
	}
	
	static Person findAny() {
		return PersonRepository.getAllPersons()
				.stream()
				.filter(p2.and(p3))
				.findAny()
				.get();
	}
	
	static Person findFirst() {
		return PersonRepository.getAllPersons()
				.stream()
				.filter(p3)
				.findFirst()
				.get();
	}
}
