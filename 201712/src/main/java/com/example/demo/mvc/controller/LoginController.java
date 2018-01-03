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
package com.example.demo.mvc.controller;


import com.example.demo.mvc.model.User;
import com.example.demo.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//可以自动将类User转换成Json结果

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String list(){
		return "editUserList";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}


	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User add(String email, String userName, String password) {
		User user = new User();
		user.setEmail(email);
		user.setUserName(userName);
		user.setPassword(password);
		userService.CreateUser(user);
		return user;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	//自动将User转为rest response
	@ResponseBody
	public User select(@RequestParam(value="email") String email) throws InterruptedException {
		User user = userService.getUserByEmail(email);
		return  user;
	}
}
