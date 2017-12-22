package com.example.demo;

import com.example.demo.annotation.Name;
import com.example.demo.aop.Test;
import com.example.demo.autowire.Zoo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;


@SpringBootApplication
public class AutowireApplication {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// autowire test -----------
		Zoo zoo = (Zoo)context.getBean("zoo");
		System.out.println(zoo);
		// autowire test -----------

		// aop test begin----------
		Test bean = context.getBean(Test.class);
		bean.Case1();
		// aop test end------------

		// annotation begin--------
		Class demoClass = Class.forName("com.example.demo.annotation.DemoClass");
		Annotation[] annotations = demoClass.getMethod("Case1").getAnnotations();
		for (Annotation annotation :
				annotations) {
			if (annotation instanceof Name)
			{
				Name name = (Name)annotation;
				System.out.println(name.community() + " " + name.originate());
			}
		}

		// annotation end----------

		SpringApplication.run(AutowireApplication.class, args);
	}
}
