package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by chunmei on 1/24/2018.
 */

//@FeignClient(value = "service-core",fallback = UserServiceHystric.class)
@FeignClient(value = "service-core")
public interface UserFeignClient {
    @RequestMapping("/login")
    String login();

    @RequestMapping("/test")
    String test();

}
