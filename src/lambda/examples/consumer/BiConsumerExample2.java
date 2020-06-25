package lambda.examples.consumer;

import java.util.List;
import java.util.function.BiConsumer;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class BiConsumerExample2 {
	
	static void printPersonDetails() {
		
		BiConsumer<String, List<String>> personConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);
		List<Person> personList = PersonRepository.getAllPersons();
		
		personList.forEach(p -> personConsumer.accept(p.getName(), p.getHobbies()));
	}
	
	public static void main(String[] args) {
		printPersonDetails();		
	}

}
