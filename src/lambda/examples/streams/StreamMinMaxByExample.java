package lambda.examples.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class StreamMinMaxByExample {

	static List<Person> peopleList = PersonRepository.getAllPersons();	
	static BinaryOperator<Person> c1 = (person1, person2) -> person1.getHeight() >= person2.getHeight() ? person1 : person2;
	
	static Optional<Person> getTallestPerson() {
		return peopleList
				.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Person::getHeight)));
	}
	
	static Optional<Person> getShortestPerson(){
		return peopleList
				.stream()
				.collect(Collectors.minBy(Comparator.comparing(Person::getHeight)));
	}
	
	static List<Person> getTallestPeopleList(){
		
		Person tPerson = peopleList
				.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Person::getHeight))).get();
		
		List<Person> tallestPeople = null;
		
		if(tPerson != null) {
			tallestPeople = peopleList
					.stream()
					.filter(per -> per.getHeight() == tPerson.getHeight())
					.collect(Collectors.toList());
		}
		
		return tallestPeople;
	}
	
	public static void main(String[] args) {
		System.out.println("Tallest person: " + getTallestPerson().get());
		System.out.println("Shortest person: " + getShortestPerson().get());
		System.out.println("Tallest people: " + getTallestPeopleList());
	}		
}
