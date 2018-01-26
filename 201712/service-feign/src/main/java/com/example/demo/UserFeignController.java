package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chunmei on 1/24/2018.
 */
@RestController
public class UserFeignController {

    @Qualifier("userServiceHystric")
    @Autowired
    UserFeignClient userFeignClient;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String sayHi(){
        return userFeignClient.login();
    }

    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String sayTest(){
        return userFeignClient.test();
    }
}

