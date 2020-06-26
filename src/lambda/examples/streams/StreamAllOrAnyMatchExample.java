package lambda.examples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class StreamAllOrAnyMatchExample {

	static Predicate<String> p1 = p -> p.length() >= 6;
	static Predicate<Person> p2 = person -> person.getHeight() >= 140;
	static Predicate<Person> p3 = person -> person.getGender().equals("Female");
	static Predicate<Person> p4 = person -> person.getHeight() == 158;
	
	public static void main(String[] args) {
		
		List<String> fruits = Arrays.asList("Apple", "Orange", "Graphs", "Bannana", "Pineaple");
		
		// allMatch verify if every element on the stream match the condition
		// Verifica que cada elemento del stream cumpla la condición
		Boolean result = fruits.stream().allMatch(p1);		
		System.out.println("Every fruit is >= 6 " + result);
				
		System.out.println("-------------------------");
		//Verify that at least one element of the stream match the condition
		result = fruits.stream().anyMatch(p1);
		System.out.println("At least one is >= 6 " + result);
		
		result = PersonRepository.getAllPersons()
				.stream()
				.allMatch(p2);
		
		System.out.println("All people is >= 140 " + result);
		
		result = PersonRepository.getAllPersons()
				.stream()
				.anyMatch(p4.and(p3));
		
		System.out.println("At least one person is 158 and Female " + result);
	}
}
