package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Created by chunmei on 1/24/2018.
 */
@Component
public class UserServiceHystric implements UserFeignClient {
//public class UserServiceHystric {
    @Override
    public String login() {
        return "Sorry...";
    }

    @Override
    public String test() {
        return "Sorry2...";
    }
}
