package com.example.demo;

import com.example.demo.annotation.Name;
import com.example.demo.aop.Test;
import com.example.demo.autowire.Zoo;
import com.example.demo.concurrent.ConcurrentCalculator;
import com.example.demo.concurrent.ConcurrentCalculator2;
import com.example.demo.mvc.model.Role;
import com.example.demo.mvc.model.User;
import com.example.demo.mvc.repository.UserRepository;
import com.example.demo.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.GrantedAuthority;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;


@SpringBootApplication
@EnableCaching
public class TestApplication {
	public static void main(String[] args) throws Exception {

		// concurrent test -------
		ConcurrentCalculator2 calculator = new ConcurrentCalculator2();
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.print(calculator.sum(numbers));
		calculator.close();
		// concurrent test -------


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



		// hibernate begin -----------
        UserRepository userRepository = context.getBean(UserRepository.class);
		UserService userService = context.getBean(UserService.class);
		List<User> users = userRepository.findAllByUserNameEqualsAndEmailEquals("test1", "1@email.com");
		User user = userRepository.findByEmail("1@email.com");
		Collection<? extends GrantedAuthority> authorities = userService.getPermissions(user.getId());


		// hibernate end -----------
		SpringApplication.run(TestApplication.class, args);
	}
}
