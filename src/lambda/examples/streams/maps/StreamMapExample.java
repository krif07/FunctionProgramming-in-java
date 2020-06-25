package lambda.examples.streams.maps;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class StreamMapExample {

	static List<String> toUpperTransform(List<Person> peopleList){
		return peopleList.stream()
				.map(Person::getName)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
	}
	
	static Set<String> toUpperTransformSet(List<Person> peopleList){
		return peopleList.stream()
				.map(Person::getName)
				.map(String::toUpperCase)
				.collect(Collectors.toSet());
	}
	
	public static void main(String[] args) {
		
		List<String> fruitList = Arrays.asList("Banana", "Pineapol", "Orange", "Apple");
		
		List<Integer> fruitLength = fruitList.stream()
			.map(String::length)
			.collect(Collectors.toList());
		
		System.out.println("Length " + fruitLength);
		System.out.println("-----------------------");
		
		fruitList.stream()
			.map(String::length)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("--------------------");
		
		fruitList.stream()
			.map(String::length)
			.collect(Collectors.toList())
			.forEach(p -> System.out.println(p));
		
		System.out.println("--------------------");
		System.out.println(toUpperTransform(PersonRepository.getAllPersons()));
		
		System.out.println("--------------------");
		System.out.println(toUpperTransformSet(PersonRepository.getAllPersons()));
		
	}
}
