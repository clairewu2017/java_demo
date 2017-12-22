package com.example.demo;

import com.example.demo.aop.Test;
import com.example.demo.autowire.Zoo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class AutowireApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// autowire test -----------
		Zoo zoo = (Zoo)context.getBean("zoo");
		System.out.println(zoo);
		// autowire test -----------


		// aop test begin
		Test bean = context.getBean(Test.class);
		bean.Case1();

		// aop test end
		SpringApplication.run(AutowireApplication.class, args);
	}
}
