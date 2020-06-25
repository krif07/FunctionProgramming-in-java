package lambda.examples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class StreamFilterExample {
	
	static Predicate<String> p1 = name -> name.length() >= 4;
	static Predicate<Person> p2 = person -> person.getGender().equals("Male"); 
	static Predicate<Person> p3 = person -> person.getKids() > 1;
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("krif", "Pedro", "Juan", "Marcela", "Javier", "Michael");		
		Stream<String> allNames = names.stream();
		Stream<String> filterList =  allNames.filter(p -> p.length() > 5);		
		filterList.forEach(p -> System.out.println(p));
		
		System.out.println("------------------------------------");
		
		names.stream()
		.filter(p1)
		.forEach(System.out::println);
		
		
		System.out.println("------------ generando una lista -----------------");
		
		List<String> withFilter = names.stream()
				.filter(p1)
				.collect(Collectors.toList());
		
		withFilter.forEach(System.out::println);
		
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		
		List<Person> peopleListFiltered = PersonRepository.getAllPersons()
		.stream()
		.filter(p2.and(p -> p.getHeight() > 140).and(p -> p1.test(p.getName())))
		.collect(Collectors.toList());
		
		peopleListFiltered.forEach(System.out::println);
		
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		
		PersonRepository.getAllPersons()
		.stream()
		.filter(p2.and(p3))
		//.filter(P3)
		//.filter(person -> person.getKids() > 1)
		.forEach(System.out::println);
	}

}
