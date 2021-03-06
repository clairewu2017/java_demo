/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.innover.controller;

import com.innover.data.User;
import com.innover.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list() {
		return "editUserList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public User add() {
		User user = new User();
		user.setEmail("chunmei@innover.com");
		user.setFirstName("chunmei");
		user.setLastName("wu");

		user.setPassword(new BCryptPasswordEncoder().encode("password"));
		userService.CreateUser(user);
		return user;
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public User select() throws InterruptedException {
		return userService.getUserByEmail("rob@innover.com");
	}
}
