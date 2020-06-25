package lambda.examples.methodreference;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class MethodReferenceExample2 {
	
	static Function<String, String> f1 = name -> name.toUpperCase();
	static Predicate<Person> p1 = person -> person.getHeight() >= 140;
	static Function<Person, String> fPerson1 = person -> person.getName();
	
	/* Sintax */
	// ClassName :: method
	static Function<String, String> f2 = String::toUpperCase;
	static Predicate<Person> p2 = MethodReferenceExample2::checkHeight;
	static Function<Person, String> fPerson2 = Person::getName;
	static BiPredicate<Person, Integer> p3 = MethodReferenceExample2::checkHeightWithParam;
	
	public static void main(String[] args) {
				
		List<Person> personList = PersonRepository.getAllPersons();
		
		System.out.println("Lambda expresssion Result " +  f1.apply("Cristian Dávila"));
		System.out.println("Method Reference Result " + f2.apply("Pepe garcía"));
		
		System.out.println("Lambda expresssion Result " + p1.test(personList.get(0)));
		System.out.println("Method Reference Result " + p2.test(personList.get(1)));
		System.out.println("Method Reference Result " + p3.test(personList.get(1), 1500));
		
		System.out.println("Lambda expression R " + fPerson1.apply(personList.get(0)));
		System.out.println("Method Reference R " + fPerson2.apply(personList.get(1)));
		
	}
	
	static boolean checkHeight(Person person) {
		return person.getHeight() >= 140;
	}
	
	static boolean checkHeightWithParam(Person person, Integer height) {
		return person.getHeight() >= height;
	}

}
