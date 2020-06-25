package lambda.examples.predicates;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class BiPredicateExample {

	static BiPredicate<Integer, String> p1 = (height, gender) -> height > 140 && gender.equals("Male");
	static BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> System.out.println("Name: " + name + " - Hobbies: " + hobbies);	
	static Consumer<Person> personConsumer = person -> {
		if(p1.test(person.getHeight(), person.getGender())) {
			hobbiesConsumer.accept(person.getName(), person.getHobbies());
		}
	};
	
	public static void main(String[] args) {
		List<Person> personList = PersonRepository.getAllPersons();
		personList.forEach(personConsumer);
	}
	
}
