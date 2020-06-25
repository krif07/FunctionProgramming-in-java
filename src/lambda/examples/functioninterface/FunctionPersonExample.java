package lambda.examples.functioninterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class FunctionPersonExample {
	
	/*static Function<Person, Consumer<Person>> personConsumer = person -> {
		Map<String, Double> map = new HashMap<>();
		return p -> {
			map.put(p.getName(), p.getSalary());
		};
	};*/
	
	static Predicate<Person> p1 = person -> person.getHeight() > 140;
	static Predicate<Person> p2 = person -> person.getGender().equals("Male");
	
	static Function<List<Person>, Map<String, Double>> f1 = personList -> {
		Map<String, Double> map = new HashMap<>();
		personList.forEach(person -> {
			if(p1.and(p2).test(person))	
				map.put(person.getName(), person.getSalary());
		});		
		return map;
	};
	
	public static void main(String[] args) {
		List<Person> personList = PersonRepository.getAllPersons();
		Map<String, Double> map = f1.apply(personList);
		System.out.println(map);
	}

}
