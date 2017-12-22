package com.example.demo;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	// Method 1: Use repository to operate Mongodb
	public void useRepository()
	{
		//----------------using repository--------------
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}

	// Method 2: Use mongotemplate to do some complex query
	public void useTemplate()
	{
		//------using mongotemplate
		MongoOperations mongoOps = new MongoTemplate(new Mongo("192.168.200.122"),"test");
		mongoOps.insert(new Customer("Joe", "Toe"));

		System.out.println("-------------------------------");
		System.out.println(mongoOps.findOne(new Query(where("firstName").is("Joe")).addCriteria(where("lastName").is("Toe")), Customer.class));
		System.out.println("-------------------------------");
	}
	public static void main(String[] args) {
		System.out.println("----xx---");
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		useTemplate();
	}
}
