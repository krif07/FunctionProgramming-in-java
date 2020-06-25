package lambda.examples.functioninterface;

import java.util.List;
import java.util.function.Supplier;

import lambda.examples.repo.Person;
import lambda.examples.repo.PersonRepository;

public class SupplierExample {

	static Supplier<Person> s1 = () -> PersonRepository.getPerson();
	static Supplier<List<Person>> s2 = () -> PersonRepository.getAllPersons(); 
 	
	public static void main(String[] args) {
		
		System.out.println(s1.get());
		System.out.println("--------------------------------------");
		System.out.println(s2.get());
	}
}
