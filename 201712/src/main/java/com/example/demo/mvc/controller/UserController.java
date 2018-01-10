package com.example.demo.mvc.controller;

import com.example.demo.mvc.model.User;
import com.example.demo.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chunmei on 1/3/2018.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/buy/user", method = RequestMethod.GET)
    //自动将User转为rest response
    @ResponseBody
    public User select(@RequestParam(value="email") String email) throws InterruptedException {
        User user = userService.getUserByEmail(email);
        return  user;
    }

    @RequestMapping(value = "/buy/user", method = RequestMethod.POST)
    public User add(User user) {
        userService.createUser(user);
        return user;
    }

    @RequestMapping(value = "/buy/user", method = RequestMethod.DELETE)
    public void delete(@RequestParam("id") long id) {
        userService.delete(id);
    }



    @RequestMapping(value = "/buy/users", method = RequestMethod.GET)
    //可以使用Model, Map,或者ModelAndView来和html template交互
    public String list(Model model){
        model.addAttribute("employeeList", userService.getAll());
        model.addAttribute("user", new User());
        return "user";
    }

    @RequestMapping(value="/buy/users_page", params = {"page", "size"}, method = RequestMethod.GET)
    public String ListPage(@RequestParam("page") int page, @RequestParam("size") int size, Model model)
    {
        Page<User> list = userService.getAllByPage(new PageRequest(page, size));
        model.addAttribute("employeeList", list);
        return "user";
    }

}
