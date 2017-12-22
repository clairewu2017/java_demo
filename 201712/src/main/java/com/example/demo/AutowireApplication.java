package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class AutowireApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Zoo zoo = (Zoo)context.getBean("zoo");
		System.out.println(zoo);
		SpringApplication.run(AutowireApplication.class, args);
	}
}
