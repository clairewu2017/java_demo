package com.example.demo;

import com.example.demo.mvc.model.User;
import com.example.demo.mvc.repository.UserRepository;
import com.example.demo.mvc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;


@SpringBootApplication
@EnableCaching
@EnableDiscoveryClient
public class CoreServiceApplication {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// hibernate begin -----------
        UserRepository userRepository = context.getBean(UserRepository.class);
		UserService userService = context.getBean(UserService.class);
		List<User> users = userRepository.findAllByUserNameEqualsAndEmailEquals("test1", "1@email.com");
		User user = userRepository.findByEmail("1@email.com");
		Collection<? extends GrantedAuthority> authorities = userService.getPermissions(user.getId());
		// hibernate end -----------
		SpringApplication.run(CoreServiceApplication.class, args);
	}
}
