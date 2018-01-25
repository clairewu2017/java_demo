package com.example.demo;

import com.example.demo.mvc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoreServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void userTest(){
		ResponseEntity<User> responseEntity2 = restTemplate.getForEntity("/api/user/1", User.class);
		User user = new User();
		user.setUserName("case");
		user.setEmail("case@email.com");
		user.setLocation("case");
		ResponseEntity<String> responseEntity1 = restTemplate.postForEntity("/buy/user", user, String .class);
		assert(responseEntity1.getStatusCode() == HttpStatus.OK);


		//或者使用mockMvc
	}

}
