package lambda.examples.streams.maps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class StreamFlatMapExample {

	static List<String> hobbies(List<Person> listOfPeople){
		return listOfPeople.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
	}
	
	static long countNumberOfHobbies(List<Person> listOfPeople) {
		return listOfPeople.stream()
				.map(Person::getHobbies)
				.flatMap(List::stream)
				.distinct()
				.count();
	}
	
	public static void main(String[] args) {
		
		List<Integer> oddNumbers = Arrays.asList(1,3,5,7,9);
		List<Integer> evenNumbers = Arrays.asList(2,4,6,8);
		
		List<List<Integer>> listOfNumbers = Arrays.asList(oddNumbers, evenNumbers);
		System.out.println("Before flatten");
		System.out.println(listOfNumbers);
		
		System.out.println("After flatten");
		
		List<Integer> flattenList = listOfNumbers
				.stream()
				.flatMap(list -> list.stream())
				.collect(Collectors.toList());
		
		System.out.println(flattenList);
		
		System.out.println("List of people flatted");
		System.out.println(hobbies(PersonRepository.getAllPersons()));
		
		System.out.println("Count the hobbies");
		System.out.println(countNumberOfHobbies(PersonRepository.getAllPersons()));
	}
}
