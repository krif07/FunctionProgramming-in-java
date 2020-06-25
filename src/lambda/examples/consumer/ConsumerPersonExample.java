package lambda.examples.consumer;

import java.util.List;
import java.util.function.Consumer;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class ConsumerPersonExample {

	static Consumer<Person> c1 = p -> System.out.println(p);
	static Consumer<Person> c2 = p -> System.out.println(p.getName().toUpperCase());
	static Consumer<Person> c3 = p -> System.out.println(p.getHobbies());
	
	static List<Person> personList = PersonRepository.getAllPersons();
	
	static void printNameAndHobies() {		
		personList.forEach(c2.andThen(c3));
	}
	
	static void printWithCondition(){
		personList.forEach(p -> {
			if(p.getGender().equals("Male") && p.getHeight() >= 140 ) {
				c2.andThen(c3).accept(p);
			}
		});
	}
	public static void main(String[] args) {
				
		//c1.accept(PersonRepository.getPerson());
		//c2.accept(PersonRepository.getPerson());
		//c3.accept(PersonRepository.getPerson());
		
		//c1.andThen(c2).andThen(c3).accept(PersonRepository.getPerson());
		
		//printNameAndHobies();
		printWithCondition();
	}
}
