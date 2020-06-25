package lambda.examples.functioninterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class BiFunctionExample {

	private static BiFunction<String, String, String> bf1 = (a,b) -> (a + " - " + b);
	private static Predicate<Person> p1 = person -> person.getHeight() > 140;
	private static Predicate<Person> p2 = person -> person.getGender().equals("Male");
	
	private static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> bf2 = (personList, predicate) -> {
		Map<String, Double> map = new HashMap<>();
		personList.forEach(person -> {
			if(predicate.test(person)) {
				map.put(person.getName(), person.getSalary());
			}
		});
		
		return map;
	};
	
	public static void main(String[] args) {
		System.out.println(bf1.apply("krif", "07"));
		
		List<Person> personList = PersonRepository.getAllPersons();
		
		Map<String, Double> map1 = bf2.apply(personList, p1);
		System.out.println("map1: " + map1);
		
		Map<String, Double> map2 = bf2.apply(personList, p2);
		System.out.println("map2: " + map2);
	}
}
