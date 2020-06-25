package lambda.examples.predicates;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class ConsumerPredicateExample {

	static Predicate<Person> p1 = person -> person.getHeight() > 140;
	static Predicate<Person> p2 = person -> person.getGender().equals("Male");
	static BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> System.out.println("Name: " + name + " - Hobies: " + hobbies);
	static Consumer<Person> personConsumer = person -> {
		if(p1.and(p2).test(person)) {
			hobbiesConsumer.accept(person.getName(), person.getHobbies());
		}
	};
	
	public static void main(String[] args) {
		List<Person> personList = PersonRepository.getAllPersons();
		personList.forEach(personConsumer);
	}
	
}
